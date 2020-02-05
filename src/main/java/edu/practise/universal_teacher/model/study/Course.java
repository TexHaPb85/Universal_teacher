package edu.practise.universal_teacher.model.study;

import com.fasterxml.jackson.annotation.JsonIgnore;


import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;


@Entity
@Table(name = "courses")
public class Course implements Serializable {

    @Id
    @Column(name = "course_name")
    private String courseName;

    private double courseDifficulty;

    @OneToMany(mappedBy = "course")
    private Set<CourseProfileRelation> relations;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Lesson> lessons;

    public Course(String courseName, double courseDifficulty, Set<CourseProfileRelation> relations, List<Lesson> lessons) {
        this.courseName = courseName;
        this.courseDifficulty = courseDifficulty;
        this.relations = relations;
        this.lessons = lessons;
    }

    public Course() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCourseDifficulty() {
        return courseDifficulty;
    }

    public void setCourseDifficulty(double courseDifficulty) {
        this.courseDifficulty = courseDifficulty;
    }

    public Set<CourseProfileRelation> getRelations() {
        return relations;
    }

    public void setRelations(Set<CourseProfileRelation> relations) {
        this.relations = relations;
    }

    public List<Lesson> getLessons() {
        return lessons;
    }

    public void setLessons(List<Lesson> lessons) {
        this.lessons = lessons;
    }
}
