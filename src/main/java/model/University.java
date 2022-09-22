package model;

import com.google.gson.annotations.SerializedName;
import enums.StudyProfile;

public class University {
    //пункт 11 добавить аннотацию @SerializedName для каждого поля для изменения названия поля в сериализованном json
    @SerializedName("id")
    private String id;
    @SerializedName("полное название")
    private String fullName;
    @SerializedName("сокращенное название")
    private String shortName;
    @SerializedName("year")
    private int yearOfFoundation;
    @SerializedName("profile")
    private StudyProfile mainProfile;

    public University() {
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, StudyProfile mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        //StudyProfile = studyProfile;
        this.mainProfile = mainProfile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public int getYearOfFoundation() {
        return yearOfFoundation;
    }

    public void setYearOfFoundation(int yearOfFoundation) {
        this.yearOfFoundation = yearOfFoundation;
    }

    public StudyProfile getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(StudyProfile mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return String.format("id: %s, название: %s (%s), основан в %dг., профиль: %s",
                id,
                fullName,
                shortName,
                yearOfFoundation,
                mainProfile.getProfileName());
    }
}
