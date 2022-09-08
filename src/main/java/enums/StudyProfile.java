package enums;

public enum StudyProfile {
    PHYSICS("Физика"),
    COMPUTER_SCIENCE("Информатика"),
    JAVA("JAVA-разработчик"),
    MEDICINE("Медицина"),
    HISTORY("История"),
    MATHEMATICS("Математика");

    private final String profileName;

    private StudyProfile(String profileName){
        this.profileName=profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}
