package edu.practise.universal_teacher.entities.enums;

public enum Achievement {
    ENGLISH_COURCE_FINISHED("URL", "Finish course of english"),
    MATH_COURCE_FINISHED("Math", "Finish course of english"),
    JAVA_COURCE_FINISHED("Java", "Finish course of english"),
    THREE_DAYS_IN_A_ROW("3", "Visit application 3 days in a row"),
    SEVEN_DAYS_IN_A_ROW("7", "Visit application 7 days in a row"),
    FIFTEEN_DAYS_IN_A_ROW("15", "Visit application 15 days in a row"),
    MOUNTH_IN_A_ROW("30", "Visit application 30 days in a row");

    private String photoOfAchievement;
    private String descriptionOfAchievement;

    Achievement(String photoOfAchievement, String descriptionOfAchievement) {
        this.photoOfAchievement = photoOfAchievement;
        this.descriptionOfAchievement = descriptionOfAchievement;
    }

    public String getPhotoOfAchivement() {
        return photoOfAchievement;
    }

    public String getDescriptionOfAchievement() {
        return descriptionOfAchievement;
    }
}
