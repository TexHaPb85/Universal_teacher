package edu.practise.universal_teacher.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "app_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String email;
    private String password;

    private Set<Role> roles;

}
