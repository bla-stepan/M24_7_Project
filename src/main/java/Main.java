import comparator.StudentComparator;
import comparator.UniversityComparator;
import enums.StudentComparatorEnum;
import enums.UniversityComparatorEnum;
import io.FileReader;
import model.Student;
import model.University;


import java.io.IOException;
import java.util.List;

/**
Очистить метод main от предыдущего кода. Вместо этого реализовать получение коллекций с использованием написанного
в п.4 класса, затем вывести в консоль все полученные элементы коллекций.
Дополнительное задание (теоретическое): разобраться, почему для Apache POI оказалось
достаточно использовать только одну подключенную в Maven зависимость без указания других частей POI,
которые, казалось бы, тоже надо упоминать.
 */
public class Main {

    static final String fileName = "src/main/resources/universityInfo.xlsx";
    public static void main(String[] args) throws IOException {
        //Student student = new Student("Stepan", "1", 1, 6);
        //University university = new University("1", "Ярославский гос. технический университет", "ЯГТУ", 1943, 1, 1);
        //System.out.println(student.toString());
        //System.out.println(university.toString());
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
        UniversityComparator universityComparator = ComparatorEnumUtil.getUniversityComparator(UniversityComparatorEnum.FULL_NAME);
//        for (University university: universityList){
//            System.out.println(university);
//        }
        universityList.stream().sorted(universityComparator).forEach(System.out::println);

        //реализовать получение компилятора по типу

    }
}
