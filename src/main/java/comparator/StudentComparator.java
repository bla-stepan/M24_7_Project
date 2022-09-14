package comparator;
//1. Создать интерфейсы-компораторы для классов Студент и Университет. Унаследовать их от класса Comparator<>
import model.Student;

import java.util.Comparator;

public interface StudentComparator extends Comparator<Student> {

}
