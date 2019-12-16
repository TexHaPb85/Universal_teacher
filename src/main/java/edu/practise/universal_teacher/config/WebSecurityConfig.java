package edu.practise.universal_teacher.config;

import edu.practise.universal_teacher.entities.user.User;
import edu.practise.universal_teacher.entities.user.UsrProfile;
import edu.practise.universal_teacher.reposetories.UserRepository;
import edu.practise.universal_teacher.services.usr.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.web.bind.annotation.CrossOrigin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

    public WebSecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**", "/js/**", "/error**").permitAll()
                .anyRequest().authenticated()
                //.and()
                  //  .oauth2Login().defaultSuccessUrl("/courses")
                .and()
                    .logout().logoutSuccessUrl("/").permitAll()
                .and()
                    .csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }


    /**
     * during google authorization we are looking for user with the same Id im DB,
     * if we haven`t found it, we get info from google account add it to db
     */
    @Bean
    public PrincipalExtractor principalExtractor(UserRepository userRepository) {
        return map -> {
            String id = (String) map.get("sub");
            System.out.println(map);
            System.out.println("id:" + id);
            System.out.println("user:" + userRepository.findById(id));
            User loggedInUser = userRepository.findById(id).orElseGet(() -> {
                User newUser = new User();
                UsrProfile newProfile = new UsrProfile();

                newUser.setId(id);
                newUser.setEmail((String) map.get("email"));

                newProfile.setId(id);
                newProfile.setLogin((String) map.get("name"));
                newProfile.setPhotoURL((String) map.get("picture"));
                newProfile.setLocale((String) map.get("locale"));

                newUser.setProfile(newProfile);
                return userRepository.save(newUser);
            });

            loggedInUser.getProfile().setLastVisitDate(LocalDateTime.now());
            return loggedInUser;
        };
    }
}
