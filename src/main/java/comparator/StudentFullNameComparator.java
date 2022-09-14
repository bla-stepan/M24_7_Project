package comparator;

import model.Student;
import org.apache.commons.lang3.StringUtils;

public class StudentFullNameComparator implements StudentComparator{
    //2. для каждого поля классов Студент, Университет создать класс-компоратор (сравниватель) реализующий метод интерфейсов студенткорпоратор и университеткомпоратор
    @Override
    public int compare(Student o1, Student o2) {
        return StringUtils.compare(o1.getFullName(), o2.getFullName());//обернули в класс StringUtils
    }
}
