package edu.practise.universal_teacher.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import edu.practise.universal_teacher.entities.dto.UsrProfileDTO;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "profiles")
public class UsrProfile {
    @Id
    @Column(name = "prof_id")
    private String id;

    private String login;
    private String photoURL;
    private Integer age;
    private Long experience;
    private Integer level;
    private String locale;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime lastVisitDate;

    @OneToOne(mappedBy = "profile")
    @JsonIgnore
    private User user;

    @ManyToMany
    private List<Course> courses;

    //@OneToMany(mappedBy = "profiles")S
    //private Set<Achievement> achievements;


    public UsrProfile(String id, String login, String photoURL, Integer age, Long experience, Integer level, String locale, LocalDateTime lastVisitDate, User user) {
        this.id = id;
        this.login = login;
        this.photoURL = photoURL;
        this.age = age;
        this.experience = experience;
        this.level = level;
        this.locale = locale;
        this.lastVisitDate = lastVisitDate;
        this.user = user;
    }

    public UsrProfile() {
    }

    public UsrProfile(String login, String photoURL, Integer age, Long experience, Integer level,
                      User user, /*Set<Achievement> achievements,*/ LocalDateTime lastVisitDate, String locale) {
        this.login = login;
        this.photoURL = photoURL;
        this.age = age;
        this.experience = experience;
        this.level = level;
        this.user = user;
        this.lastVisitDate=lastVisitDate;
        //this.achievements = achievements;
        this.locale = locale;
    }

    public UsrProfile(String login, String photoURL, Integer age, Long experience, Integer level) {
        this.login = login;
        this.photoURL = photoURL;
        this.age = age;
        this.experience = experience;
        this.level = level;
        this.lastVisitDate=LocalDateTime.now();
    }

    public UsrProfile(UsrProfileDTO profileDTO) {
        this.login = profileDTO.getLogin();
        this.photoURL = profileDTO.getPhotoURL();
        this.age = profileDTO.getAge();
        this.experience = profileDTO.getExperience();
        this.level = profileDTO.getLevel();
        this.lastVisitDate = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getLastVisitDate() {
        return lastVisitDate;
    }

    public void setLastVisitDate(LocalDateTime lastVisitDate) {
        this.lastVisitDate = lastVisitDate;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    /* public Set<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(Set<Achievement> achievements) {
        this.achievements = achievements;
    }*/

    @Override
    public String toString() {
        return "UsrProfile{" +
                "id='" + id + '\'' +
                ", login='" + login + '\'' +
                ", photoURL='" + photoURL + '\'' +
                ", age=" + age +
                ", experience=" + experience +
                ", level=" + level +
                ", locale='" + locale + '\'' +
                ", lastVisitDate=" + lastVisitDate +
                ", user=" + user +
                '}';
    }
}
