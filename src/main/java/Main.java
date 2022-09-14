import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparatorEnum;
import enums.UniversityComparatorEnum;
import io.FileReader;
import model.Student;
import model.University;


import java.io.IOException;
import java.util.List;

public class Main {

    static final String fileName = "src/main/resources/universityInfo.xlsx";
    public static void main(String[] args) throws IOException {

        //создаем list для студентов задаем методом из класса чтения файла
        List<Student> studentList = FileReader.readerFileStudent(fileName);

        //создаем интерфейс студенткомпаратор и вызываем метод утилит-класса для студента и передаем в метод нужный класс компаратора
        StudentComparator studentComparator = ComparatorEnumUtil.getStudentComparator(StudentComparatorEnum.FULL_NAME);
        //заменить цикл стримом
//        for (Student student : studentList) {
//            System.out.println(student);
//        }
        //создаем стрим, сортируем по компаратору, каждый печатаем
        studentList.stream().sorted(studentComparator).forEach(System.out::println);

        List<University> universityList = FileReader.readerFileUniversity(fileName);
        //делаем компаратор
        UniversityComparator universityComparator = ComparatorEnumUtil.getUniversityComparator(UniversityComparatorEnum.PROFILE);
//        for (University university: universityList){
//            System.out.println(university);
//        }
        universityList.stream().sorted(universityComparator).forEach(System.out::println);



    }
}
