package edu.practise.universal_teacher.entities.study;

import com.fasterxml.jackson.annotation.JsonFormat;
import edu.practise.universal_teacher.entities.user.UsrProfile;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
public class CourseProfileRelation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String relationId;

    @ManyToOne
    @JoinColumn(name = "profile_id")
    private UsrProfile usrProfile;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "num_of_learned_lessons")
    private Integer learnedLessons;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    private LocalDateTime registeredDate;

    public CourseProfileRelation(UsrProfile usrProfile, Course course, Integer learnedLessons, LocalDateTime registeredDate) {
        this.usrProfile = usrProfile;
        this.course = course;
        this.learnedLessons = learnedLessons;
        this.registeredDate = registeredDate;
    }

    public CourseProfileRelation() {
    }

    public String getRelationId() {
        return relationId;
    }

    public void setRelationId(String relationId) {
        this.relationId = relationId;
    }

    public UsrProfile getUsrProfile() {
        return usrProfile;
    }

    public void setUsrProfile(UsrProfile usrProfile) {
        this.usrProfile = usrProfile;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Integer getLearnedLessons() {
        return learnedLessons;
    }

    public void setLearnedLessons(Integer learnedLessons) {
        this.learnedLessons = learnedLessons;
    }

    public LocalDateTime getRegisteredDate() {
        return registeredDate;
    }

    public void setRegisteredDate(LocalDateTime registeredDate) {
        this.registeredDate = registeredDate;
    }
}

