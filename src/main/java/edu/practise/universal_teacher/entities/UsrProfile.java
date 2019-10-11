package edu.practise.universal_teacher.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "profiles")
public class UsrProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    private String login;
    private String photoURL;
    private Integer age;
    private Long experience;
    private Integer level;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime lastVisitDate;

    @OneToOne(mappedBy = "profile")
    private User user;

    //@OneToMany(mappedBy = "profiles")S
    //private Set<Achievement> achievements;

    public UsrProfile() {
    }

    public UsrProfile(String login, String photoURL, Integer age, Long experience, Integer level,
                      User user, /*Set<Achievement> achievements,*/ LocalDateTime lastVisitDate) {
        this.login = login;
        this.photoURL = photoURL;
        this.age = age;
        this.experience = experience;
        this.level = level;
        this.user = user;
        this.lastVisitDate=lastVisitDate;
        //this.achievements = achievements;
    }

    public UsrProfile(String login, String photoURL, Integer age, Long experience, Integer level) {
        this.login = login;
        this.photoURL = photoURL;
        this.age = age;
        this.experience = experience;
        this.level = level;
        this.lastVisitDate=LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    /* public Set<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(Set<Achievement> achievements) {
        this.achievements = achievements;
    }*/
}
