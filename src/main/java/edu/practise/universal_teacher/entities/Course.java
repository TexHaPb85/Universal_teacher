package edu.practise.universal_teacher.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "courses")
public class Course {
    @Id
    private String courseName;
    private double courseDifficulty;

    @ManyToMany
    private List<UsrProfile> profiles;

    @JsonIgnore
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    private List<Lesson> lessons;
}
