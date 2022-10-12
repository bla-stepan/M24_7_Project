package model;

import enums.StudyProfile;

//пункт 1 задания 27.8
public class Statistics {

    private StudyProfile profile;//профиль обучения
    private float avgExamScore;//средний балл за экзамен
    private int numOfStudentsProf;//количество студентов по профилю
    private int numOfUniversityProf;//количество университетов по профилю
    private String universityName;//названия университетов.

    //конструктор дефолтный
    public Statistics() {
    }

    public int getNumOfStudentsProf() {
        return numOfStudentsProf;
    }

    public Statistics setNumOfStudentsProf(int numOfStudentsProf) {
        this.numOfStudentsProf = numOfStudentsProf;
        return this;
    }

    public int getNumOfUniversityProf() {
        return numOfUniversityProf;
    }

    public Statistics setNumOfUniversityProf(int numOfUniversityProf) {
        this.numOfUniversityProf = numOfUniversityProf;
        return this;
    }

    public StudyProfile getProfile() {
        return profile;
    }

    public Statistics setProfile(StudyProfile profile) {
        this.profile = profile;
        return this;
    }

    public float getAvgExamScore() {
        return avgExamScore;
    }

    public Statistics setAvgExamScore(float avgExamScore) {
        this.avgExamScore = avgExamScore;
        return this;
    }

    public String getUniversityName() {
        return universityName;
    }

    public Statistics setUniversityName(String universityName) {
        this.universityName = universityName;
        return this;
    }
}
