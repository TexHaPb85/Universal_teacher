package edu.practise.universal_teacher.services.usr;

import edu.practise.universal_teacher.model.study.Course;
import edu.practise.universal_teacher.model.study.CourseProfileRelation;
import edu.practise.universal_teacher.model.user.User;
import edu.practise.universal_teacher.model.user.UsrProfile;
import edu.practise.universal_teacher.model.dto.UsrProfileDTO;

import java.util.List;

public interface UsrProfileService {
    List<UsrProfile> getAllProfiles();

    UsrProfile getProfileById(String id);

    UsrProfile saveProfile(UsrProfileDTO usrProfile);

    void deleteProfileById(String profileId);

    UsrProfile editProfileById(String profileId, UsrProfile profile);

    List<Course> getCoursesByProfile(UsrProfile profile);

    CourseProfileRelation addCourseToUser(User user, String courseId);
}
