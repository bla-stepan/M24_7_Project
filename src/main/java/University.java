public class University {
    String id, fullName, shortName;
    int yearOfFoundation, StudyProfile, mainProfile;

    public enum StudyProfile {
        MTEMATIKA("Математика"),
        MEDICINA("Медицина"),
        JAVA("Java-разработчик"),
        FIZICA("Физика");

        StudyProfile(String profileName) {

        }
    }

    public University(String id, String fullName, String shortName, int yearOfFoundation, int studyProfile, int mainProfile) {
        this.id = id;
        this.fullName = fullName;
        this.shortName = shortName;
        this.yearOfFoundation = yearOfFoundation;
        StudyProfile = studyProfile;
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

    public int getStudyProfile() {
        return StudyProfile;
    }

    public void setStudyProfile(int studyProfile) {
        StudyProfile = studyProfile;
    }

    public int getMainProfile() {
        return mainProfile;
    }

    public void setMainProfile(int mainProfile) {
        this.mainProfile = mainProfile;
    }

    @Override
    public String toString() {
        return "University{" +
                "id='" + id + '\'' +
                ", fullName='" + fullName + '\'' +
                ", shortName='" + shortName + '\'' +
                ", yearOfFoundation=" + yearOfFoundation +
                ", StudyProfile=" + StudyProfile +
                ", mainProfile=" + mainProfile +
                '}';
    }
}
