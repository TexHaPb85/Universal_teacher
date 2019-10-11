package edu.practise.universal_teacher.services.usr;

import edu.practise.universal_teacher.entities.UsrProfile;
import edu.practise.universal_teacher.exceptions.ProfileNotFoundException;
import edu.practise.universal_teacher.reposetories.UsrProfileRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsrProfileServiceImpl implements UsrProfileService {

    private final UsrProfileRepository repository;

    @Autowired
    public UsrProfileServiceImpl(UsrProfileRepository repository) {
        this.repository = repository;
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
    public UsrProfile saveProfile(UsrProfile usrProfile) {
        return repository.save(usrProfile);
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
