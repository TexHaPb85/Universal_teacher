package edu.practise.universal_teacher.services.usr;

import edu.practise.universal_teacher.entities.UsrProfile;
import edu.practise.universal_teacher.entities.dto.UsrProfileDTO;

import java.util.List;

public interface UsrProfileService {
    List<UsrProfile> getAllProfiles();

    UsrProfile getProfileById(String id);

    UsrProfile saveProfile(UsrProfileDTO usrProfile);

    void deleteProfileById(String profileId);

    UsrProfile editProfileById(String profileId, UsrProfile profile);


}
