public class Main {
    public static void main(String[] args) {
        Student student = new Student("Stepan", "1", 1, 6);
        University university = new University("1", "Ярославский гос. технический университет", "ЯГТУ", 1943, 1, 1);
        System.out.println(student.toString());
        System.out.println(university.toString());
    }
}
