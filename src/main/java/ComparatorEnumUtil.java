import comparator.*;
import enums.StudentComparatorEnum;
import enums.UniversityComparatorEnum;

public class ComparatorEnumUtil {

//    private ComparatorEnumUtil() {
//    }

    //метод для студентов
    public static StudentComparator getStudentComparator(StudentComparatorEnum studentComparatorEnum) {
        //в метод передается значение энума и по нему будем искать нужный класс корпоратора
        switch (studentComparatorEnum) {
            case FULL_NAME:
                return new StudentFullNameComparator();
            case UNIVERSITY_ID:
                return new StudentUniversityIdComparator();
            case COURSE_NUMBER:
                return new StudentCurrentCourseNumberComparator();
            case AVG_EXAM_SCORE:
                return new StudentAvgExamScoreComparator();
            default://нужен по умолчанию, иначе у метода не будет выхода
                return new StudentFullNameComparator();
        }
    }

    //метод для университетов
    public static UniversityComparator getUniversityComparator(UniversityComparatorEnum universityComparatorEnum) {
        switch (universityComparatorEnum) {
            case FULL_NAME:
                return new UniversityFullNameComparator();
            case ID:
                return new UniversityIdComparator();
            case SHORT_NAME:
                return new UniversityShortNameComparator();
            case PROFILE:
                return new UniversityMainProfileComparator();
            case YEAR_OF_FOUNDATION:
                return new UniversityYearOfFoundationComparator();
            default:
                return new UniversityFullNameComparator();
        }
    }
}
