package model;

import com.google.gson.annotations.SerializedName;
//пункт 11 добавить аннотацию @SerializedName для каждого поля для изменения названия поля в сериализованном json
public class Student {
    @SerializedName("Ф.И.О. студента")
    private String fullName;
    @SerializedName("universityId")
    private String universityId;
    @SerializedName("course")
    private int currentCourseNumber;
    @SerializedName("score")
    float avgExamScore;

    public Student(){}

    public Student(String fullName, String universityId, int currentCourseNumber, float avgExamScore) {
        this.fullName = fullName;
        this.universityId = universityId;
        this.currentCourseNumber = currentCourseNumber;
        this.avgExamScore = avgExamScore;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId() {
        return universityId;
    }

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }

    public int getCurrentCourseNumber() {
        return currentCourseNumber;
    }

    public void setCurrentCourseNumber(int currentCourseNumber) {
        this.currentCourseNumber = currentCourseNumber;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public void setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
    }

    @Override
    public String toString() {
        return String.format("Студент (%s), id ВУЗа: %s, текущий курс: %d, средний балл (%s)",
                fullName,
                universityId,
                currentCourseNumber,
                avgExamScore);
    }
}
