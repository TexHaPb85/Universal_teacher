package edu.practise.universal_teacher.entities.dto;

public class UsrProfileDTO {
    private String login;
    private String photoURL;
    private Integer age;
    private Long experience;
    private Integer level;

    private String userId;

    public UsrProfileDTO() {
    }

    public UsrProfileDTO(String login, String photoURL, Integer age, Long experience, Integer level, String userId) {
        this.login = login;
        this.photoURL = photoURL;
        this.age = age;
        this.experience = experience;
        this.level = level;
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPhotoURL() {
        return photoURL;
    }

    public void setPhotoURL(String photoURL) {
        this.photoURL = photoURL;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Long getExperience() {
        return experience;
    }

    public void setExperience(Long experience) {
        this.experience = experience;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
