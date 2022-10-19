import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparatorEnum;
import enums.UniversityComparatorEnum;
import io.XlsReader;
import io.XlsWriter;
import model.Statistics;
import model.Student;
import model.University;
import util.ComparatorEnumUtil;
import util.StudUniverToStatisticUtil;


import java.io.IOException;
import java.util.List;
import java.util.logging.Level;

import java.util.logging.LogManager;
import java.util.logging.Logger;


public class Main {

    private static final Logger logger = Logger.getLogger(Main.class.getName());//инициируем логгер
    static final String fileName = "src/main/resources/universityInfo.xlsx";

    public static void main(String[] args) throws IOException {


        LogManager.getLogManager().readConfiguration(Main.class.getResourceAsStream("/logging.properties"));//запускаем JUL выполнив код ниже для записи в логов в консоль и файл


        logger.log(Level.INFO, "программа запущена");//логгер при запуске программы
        //создаем list для студентов задаем методом из класса чтения файла
        List<Student> studentList = XlsReader.readerFileStudent(fileName);

        //создаем интерфейс студенткомпаратор и вызываем метод утилит-класса для студента и передаем в метод нужный класс компаратора
        StudentComparator studentComparator = ComparatorEnumUtil.getStudentComparator(StudentComparatorEnum.FULL_NAME);
        //заменить цикл стримом
//        for (Student student : studentList) {
//            System.out.println(student);
//        }
        //создаем стрим, сортируем по компаратору, каждый печатаем
        studentList.stream().sorted(studentComparator);//.forEach(System.out::println);

        List<University> universityList = XlsReader.readerFileUniversity(fileName);
        //делаем компаратор
        UniversityComparator universityComparator = ComparatorEnumUtil.getUniversityComparator(UniversityComparatorEnum.PROFILE);
//        for (University university: universityList){
//            System.out.println(university);
//        }
        universityList.stream().sorted(universityComparator);//.forEach(System.out::println);

        //пункт 4 реализовать сериализацию коллекций и вывести json в консоль
//        System.out.println("реализовать сериализацию коллекций и вывести json в консоль");
//        String jsonStudentList = JsonUtil.studentListToJson(studentList);
//        String jsonUniversityList = JsonUtil.universityListToJaon(universityList);

        //пункт 5 выполнить десериализацию полученных строк, сохранить результат в новой коллекции
//        List<Student> newStudentListFromJson = JsonUtil.studentListFromJson(jsonStudentList);
//        List<University> newUniversityListFromJson = JsonUtil.universityListFromJson(jsonUniversityList);

        //пункт 6 Сравнить количество элементов в исходной и десериализованной коллекции, для проверки корректности десериализации
//        System.out.println(String.format("Проверка: совпадение числа элементов старой и новой коллекций (студенты) - %s", studentList.size() == newStudentListFromJson.size()));
//        System.out.println(String.format("Проверка: совпадение числа элементов старой и новой коллекций (ВУЗ) - %s", universityList.size() == newUniversityListFromJson.size()));

        //пункт 7 С помощью java stream api выполнить для коллекций сериализацию отдельных элементов
//        studentList.stream().forEach(student -> {
//            String studentToJson = JsonUtil.serializationStudent(student);//пункт 7 сериализация
//            System.out.println(studentToJson);//пункт 8 печатаем сериализоваенный файл
//            Student jsonToStudent = JsonUtil.studentFromJson(studentToJson);//пункт 9 десериализуем из json
//            System.out.println(jsonToStudent);//пункт 10 проверка
//        });
//        System.out.println("==========ВУЗЫ==========");
//        universityList.forEach(university -> {
//            String universityToJson = JsonUtil.serializationUniversity(university);
//            System.out.println(universityToJson);
//            University jsonToUniversity = JsonUtil.universityFromJson(universityToJson);
//            System.out.println(jsonToUniversity);
//        });

        //11. Вызвать в методе main обработку статистики, получить коллекцию с элементами статистики, передать
        // коллекцию в метод генерации XLSX-файла.
        List<Statistics> statisticsList = StudUniverToStatisticUtil.getStatisticList(studentList, universityList);
        XlsWriter.tableGenerator(statisticsList, "src/main/resources/statisticInfo.xlsx");

        logger.log(Level.INFO, "Программа завершила работу успешно");//создаем логгер в конце программы
    }
}
