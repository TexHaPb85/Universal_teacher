package edu.practise.universal_teacher.controller;

import edu.practise.universal_teacher.entities.UsrProfile;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class ProfilesControllerTest {

    private RestTemplate restTemplate = new RestTemplate();
    private UsrProfile testAddingProfile = new UsrProfile("tester", "test.png", 20, 0L, 0);

    @Test
    public void addProfile() throws Exception {
        String usrProfilesURL = "http://localhost:8081/admin/profiles/add";
        HttpEntity<UsrProfile> request = new HttpEntity<>(testAddingProfile);

        UsrProfile profile = restTemplate.postForObject(usrProfilesURL, request, UsrProfile.class);
        assertEquals(testAddingProfile.getLogin(), profile.getLogin());
    }

    @Test
    public void getAllProfiles() throws Exception {
        String usrProfilesURL = "http://localhost:8081/admin/profiles";
        ResponseEntity<List> response = restTemplate.getForEntity(usrProfilesURL, List.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        System.out.println(response.getBody());
    }

    @Test
    public void getProfileById() throws Exception {
        String usrProfilesURL = "http://localhost:8081/admin/profiles";
        ResponseEntity<UsrProfile> response = restTemplate.getForEntity(usrProfilesURL + "/1", UsrProfile.class);
        assertEquals(response.getStatusCode(), HttpStatus.OK);

        assertEquals(testAddingProfile.getLogin(), response.getBody().getLogin());

        UsrProfile actualResponse = restTemplate.getForObject(usrProfilesURL + "/1", UsrProfile.class);
        assertEquals(testAddingProfile.getLogin(),actualResponse.getLogin());
    }

    @Test
    public void headersTest(){
        String usrProfilesURL = "http://localhost:8081/admin/profiles";
        HttpHeaders httpHeaders = restTemplate.headForHeaders(usrProfilesURL);
        System.out.println(httpHeaders.toString());
        assertTrue(httpHeaders.getContentType().includes(MediaType.APPLICATION_JSON));
    }

    @Test
    public void deleteProfile() throws Exception {

    }

}