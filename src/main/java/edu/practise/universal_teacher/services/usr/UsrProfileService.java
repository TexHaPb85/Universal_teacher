package edu.practise.universal_teacher.services.usr;

import edu.practise.universal_teacher.entities.study.Course;
import edu.practise.universal_teacher.entities.study.CourseProfileRelation;
import edu.practise.universal_teacher.entities.user.User;
import edu.practise.universal_teacher.entities.user.UsrProfile;
import edu.practise.universal_teacher.entities.dto.UsrProfileDTO;

import java.util.List;

public interface UsrProfileService {
    List<UsrProfile> getAllProfiles();

    UsrProfile getProfileById(String id);

    UsrProfile saveProfile(UsrProfileDTO usrProfile);

    void deleteProfileById(String profileId);

    UsrProfile editProfileById(String profileId, UsrProfile profile);

    List<Course> getProfileCourses(String profileId);

    CourseProfileRelation addCourseToUser(User user, String courseId);
}
