package edu.practise.universal_teacher.services.usr;

import edu.practise.universal_teacher.entities.study.Course;
import edu.practise.universal_teacher.entities.study.CourseProfileRelation;
import edu.practise.universal_teacher.entities.user.User;
import edu.practise.universal_teacher.entities.user.UsrProfile;
import edu.practise.universal_teacher.entities.dto.UsrProfileDTO;
import edu.practise.universal_teacher.exceptions.CourseNotFoundException;
import edu.practise.universal_teacher.exceptions.ProfileNotFoundException;
import edu.practise.universal_teacher.reposetories.CourseRepository;
import edu.practise.universal_teacher.reposetories.RelationRepository;
import edu.practise.universal_teacher.reposetories.UserRepository;
import edu.practise.universal_teacher.reposetories.UsrProfileRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UsrProfileServiceImpl implements UsrProfileService {

    private final UsrProfileRepository usrProfileRepository;
    private final UserRepository userRepository;
    private final RelationRepository relationRepository;
    private final CourseRepository courseRepository;

    @Autowired
    public UsrProfileServiceImpl(UsrProfileRepository usrProfileRepository, UserRepository userRepository, RelationRepository relationRepository, CourseRepository courseRepository) {
        this.usrProfileRepository = usrProfileRepository;
        this.userRepository = userRepository;
        this.relationRepository = relationRepository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<UsrProfile> getAllProfiles() {
        return usrProfileRepository.findAll();
    }

    @Override
    public UsrProfile getProfileById(String id) {
        return usrProfileRepository
                .findById(id)
                .orElseThrow(() -> new ProfileNotFoundException(id));
    }

    @Override
    public UsrProfile saveProfile(UsrProfileDTO profileDTO) {
        UsrProfile profile = new UsrProfile(profileDTO);
        User user = userRepository
                .findById(profileDTO.getUserId())
                .orElse(null);
        profile.setUser(user);

        return usrProfileRepository.save(profile);
    }

    @Override
    public void deleteProfileById(String profileId) {
        usrProfileRepository.deleteById(profileId);
    }

    @Override
    public UsrProfile editProfileById(String profileId, UsrProfile newProfileValues) {//??????????
        UsrProfile editedProfile = usrProfileRepository
                .findById(profileId)
                .orElseThrow(() -> new ProfileNotFoundException(profileId));
        BeanUtils.copyProperties(newProfileValues,editedProfile,"id");

        return usrProfileRepository.save(editedProfile);
    }

    @Override
    public List<Course> getProfileCourses(String profileId) {
        UsrProfile profile = usrProfileRepository
                .findById(profileId)
                .orElseThrow(()->new ProfileNotFoundException(profileId));
        CourseProfileRelation relation = relationRepository
                .getCourseProfileRelationByUsrProfile(profile);
        return courseRepository.getCoursesByRelations(relation);
    }

    @Override
    public CourseProfileRelation addCourseToUser(User user, String courseId){
        Course course = courseRepository
                .findById(courseId)
                .orElseThrow(()->new CourseNotFoundException(courseId));
        CourseProfileRelation relation = new CourseProfileRelation(user.getProfile(),course,0, LocalDateTime.now());
        return relationRepository.save(relation);
    }
}
