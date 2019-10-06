package edu.practise.universal_teacher.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "profiles")
public class UsrProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profilId;

    private String login;
    private String photoURL;
    private Integer age;
    private Long experience;
    private Integer level;
    private Set<Achievement> achievements;
}
