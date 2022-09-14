package comparator;
//1. Создать интерфейсы-компораторы для классов Студент и Университет. Унаследовать их от класса Comparator<>
import model.University;

import java.util.Comparator;

public interface UniversityComparator extends Comparator<University> {
}
