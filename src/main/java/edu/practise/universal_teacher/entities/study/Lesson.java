package edu.practise.universal_teacher.entities.study;

import javax.persistence.*;

@Entity
@Table(name = "lessons")
public class Lesson {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    private String theory;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    private Course course;

    public Lesson(String theory, Course course) {
        this.theory = theory;
        this.course = course;
    }

    public Lesson() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTheory() {
        return theory;
    }

    public void setTheory(String theory) {
        this.theory = theory;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id='" + id + '\'' +
                ", theory='" + theory + '\'' +
                ", course=" + course +
                '}';
    }
}
