package edu.practise.universal_teacher.entities.user;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.io.Serializable;

@Entity
@Table(name = "app_users")
public class User implements Serializable {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO) ід буде приходити з гугла, тому немає сенсу їх автогенерувати
    private String id;

    @Email
    private String email;
    //@JsonIgnore
    private String password;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "profile_id", referencedColumnName = "prof_id")
    private UsrProfile profile;

    //@OneToMany(mappedBy = "app_users")
    //private Set<Role> roles;


    public User(String id, @Email String email, String password, UsrProfile profile) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public User(@Email String email, String password, UsrProfile profile) {
        this.email = email;
        this.password = password;
        this.profile = profile;
    }

    public User() {
        this.id = "some id";
        this.email = "emptyuser@gmail.com";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsrProfile getProfile() {
        return profile;
    }

    public void setProfile(UsrProfile profile) {
        this.profile = profile;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", profile=" + profile +
                '}';
    }

}
