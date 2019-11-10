package edu.practise.universal_teacher.config;

import edu.practise.universal_teacher.entities.User;
import edu.practise.universal_teacher.entities.UsrProfile;
import edu.practise.universal_teacher.reposetories.UserRepository;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import java.time.LocalDateTime;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.antMatcher("/**")
                .authorizeRequests()
                .antMatchers("/", "/login**", "/js/**", "/error**","/**").permitAll()
                .anyRequest().authenticated()
                .and().logout().logoutSuccessUrl("/").permitAll()
                .and()

                .csrf().disable()
               ;
                /*.authorizeRequests()
                .mvcMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()*/
    }




    /**
     * during google authorization we are looking for user with the same Id im DB,
     * if we haven`t found it, we get info from google account add it to db
     *
     * @param userRepository
     * @return
     */
    @Bean
    public PrincipalExtractor principalExtractor(UserRepository userRepository) {
        return map -> {
            String id = (String) map.get("sub");
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
                return newUser;
            });

            loggedInUser.getProfile().setLastVisitDate(LocalDateTime.now());
            return userRepository.save(loggedInUser);
        };
    }
}
