package util;

import enums.StudyProfile;
import model.Statistics;
import model.Student;
import model.University;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

//6. Создать утилитный класс для обработки коллекций студентов и университетов.
public class StudUniverToStatisticUtil {

    public StudUniverToStatisticUtil() {
    }
    //создаем логгер
    public  static final Logger log = Logger.getLogger(StudUniverToStatisticUtil.class.getName());

    public static List<Statistics> getStatisticList(List<Student> students, List<University> universities) {

        //ставим логер на старт и на конец
        log.log(Level.INFO, "Начат процесс формирования статистики");
        List<Statistics> statisticsList = new ArrayList<>();
        //поток для прифилей
        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)//возвращаем значения
                .collect(Collectors.toSet());//создаем коллекцию

        profiles.forEach(studyProfile -> {//для каждого профиля (пробегаемся по коллекции)
            Statistics statistics = new Statistics();//создаем объект класса статистика
            statisticsList.add(statistics);//загружаем в коллекцию созданный объект класса статистика
            statistics.setProfile(studyProfile);//задаем параметр (текущий профиль) объекта класса статистики

            //поток1 (количество профильных ВУЗов)
            List<String> profileUniversity = universities.stream()
                    .filter(university -> university.getMainProfile().equals(studyProfile))//проверяем на соответствие профилю
                    .map(University::getId)//возвращаем значения
                    .collect(Collectors.toList());//формируем коллекцию из значений
            statistics.setNumOfUniversityProf(profileUniversity.size());//поле в количество университетов задаем размер коллекции profileUniversity

            //поток3 (количество студентов по профилю)
            List<Student> profileStudent = students.stream()
                    .filter(student -> profileUniversity.contains(student.getUniversityId()))//условие
                    .collect(Collectors.toList());//формируем коллекцию
            statistics.setNumOfStudentsProf(profileStudent.size());//заполняем поле размеров коллекции

            //поток2 (название ВУЗа)
            statistics.setUniversityName("");//StringUtil.EMPTY
            universities.stream()
                    .filter(university -> profileUniversity.contains(university.getId()))//условие
                    .map(University::getShortName)//возвращаем значения
                    .forEach(fullName -> statistics.setUniversityName(statistics.getUniversityName() + fullName+", "));

            //поток4 (средний балл) пункт 9 задания 27.8
            OptionalDouble avgScore = profileStudent.stream()
                    .mapToDouble(Student::getAvgExamScore).average();//возвращаем среднее значение баллов
            statistics.setAvgExamScore(0);//сразу ставим 0 на случай если значений нет

            //если значения имеются перебиваем поле пункт 10 задания 27.8
            avgScore.ifPresent(value ->
                    statistics.setAvgExamScore((float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });
        log.log(Level.INFO, String.format("Формирование статистики успешно завершено (сформирован список из %s элементов)", statisticsList.size()));
        return statisticsList;
    }
}
