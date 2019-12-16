package edu.practise.universal_teacher.entities.user;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import edu.practise.universal_teacher.entities.dto.UsrProfileDTO;
import edu.practise.universal_teacher.entities.enums.Achievement;
import edu.practise.universal_teacher.entities.study.CourseProfileRelation;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "profiles")
public class UsrProfile implements Serializable {
    @Id
    @Column(name = "prof_id")
    private String id;

    private String login;
    private String photoURL;
    private Integer age;
    private Long experience;
    private String locale;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime lastVisitDate;

    @OneToOne(mappedBy = "profile")
    @JsonIgnore
    private User user;

    @JsonIgnore
    @OneToMany(mappedBy = "usrProfile")//fetch = FetchType.EAGER
    private List<CourseProfileRelation> relations;


    @ElementCollection(targetClass = Achievement.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_achievements", joinColumns = @JoinColumn(name = "user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Achievement> achievements;

    public UsrProfile(String id, String login, String photoURL, Integer age, Long experience, String locale, LocalDateTime lastVisitDate, User user) {
        this.id = id;
        this.login = login;
        this.photoURL = photoURL;
        this.age = age;
        this.experience = experience;
        this.locale = locale;
        this.lastVisitDate = lastVisitDate;
        this.user = user;
    }

    public UsrProfile() {
    }

    public UsrProfile(String login, String photoURL, Integer age, Long experience,
                      User user, Set<Achievement> achievements, LocalDateTime lastVisitDate, String locale) {
        this.login = login;
        this.photoURL = photoURL;
        this.age = age;
        this.experience = experience;
        this.user = user;
        this.lastVisitDate = lastVisitDate;
        this.achievements = achievements;
        this.locale = locale;
    }

    public UsrProfile(String login, String photoURL, Integer age, Long experience) {
        this.login = login;
        this.photoURL = photoURL;
        this.age = age;
        this.experience = experience;
        this.lastVisitDate = LocalDateTime.now();
    }

    public UsrProfile(UsrProfileDTO profileDTO) {
        this.login = profileDTO.getLogin();
        this.photoURL = profileDTO.getPhotoURL();
        this.age = profileDTO.getAge();
        this.experience = profileDTO.getExperience();
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

    public List<CourseProfileRelation> getRelations() {
        return relations;
    }

    public void setRelations(List<CourseProfileRelation> relations) {
        this.relations = relations;
    }

    public Set<Achievement> getAchievements() {
        return achievements;
    }

    public void setAchievements(Set<Achievement> achievements) {
        this.achievements = achievements;
    }
}
