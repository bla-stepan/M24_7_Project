package comparator;

import model.Student;

public class StudentAvgExamScoreComparator implements StudentComparator{
//2. для каждого поля классов Студент, Университет создать класс-компоратор (сравниватель) реализующий метод интерфейсов студенткорпоратор и университеткомпоратор
    @Override
    public int compare(Student o1, Student o2) {
        return Float.compare(o2.getAvgExamScore(), o1.getAvgExamScore());//обернули в float чтобы перевести значение duoble в float
        //o1 и o2 в компаре поменять местами для выполнения условия сравнения по убыванию
    }
}
