package comparator;

import model.Student;

public class StudentCurrentCourseNumberComparator implements StudentComparator{
//2. для каждого поля классов Студент, Университет создать класс-компоратор (сравниватель) реализующий метод интерфейсов студенткорпоратор и университеткомпоратор
    @Override
    public int compare(Student o1, Student o2) {
        return Integer.compare(o1.getCurrentCourseNumber(), o2.getCurrentCourseNumber());//обвернули в класс Integer чтобы привети типы данных
    }
}
