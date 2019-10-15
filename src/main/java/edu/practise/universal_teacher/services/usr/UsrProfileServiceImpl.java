package edu.practise.universal_teacher.services.usr;

import edu.practise.universal_teacher.entities.User;
import edu.practise.universal_teacher.entities.UsrProfile;
import edu.practise.universal_teacher.entities.dto.UsrProfileDTO;
import edu.practise.universal_teacher.exceptions.ProfileNotFoundException;
import edu.practise.universal_teacher.reposetories.UserRepository;
import edu.practise.universal_teacher.reposetories.UsrProfileRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsrProfileServiceImpl implements UsrProfileService {

    private final UsrProfileRepository repository;
    private final UserRepository userRepository;

    @Autowired
    public UsrProfileServiceImpl(UsrProfileRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public List<UsrProfile> getAllProfiles() {
        return repository.findAll();
    }

    @Override
    public UsrProfile getProfileById(Long id) {
        return repository
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

        return repository.save(profile);
    }

    @Override
    public void deleteProfileById(Long profileId) {
        repository.deleteById(profileId);
    }

    @Override
    public UsrProfile editProfileById(Long profileId, UsrProfile newProfileValues) {//??????????
        UsrProfile editedProfile = repository
                .findById(profileId)
                .orElseThrow(() -> new ProfileNotFoundException(profileId));
        BeanUtils.copyProperties(newProfileValues,editedProfile,"id");

        return repository.save(editedProfile);
    }
}
