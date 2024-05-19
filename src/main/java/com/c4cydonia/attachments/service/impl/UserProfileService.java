package com.c4cydonia.attachments.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.c4cydonia.attachments.model.UserProfile;
import com.c4cydonia.attachments.repository.UserProfileRepository;
import com.c4cydonia.attachments.service.IUserProfileService;

import java.util.List;

@Service
public class UserProfileService implements IUserProfileService {

    private final UserProfileRepository repository;

    // Constructor injection
    public UserProfileService(UserProfileRepository repository) {
        this.repository = repository;
    }

    @Override
    @Transactional
    public UserProfile createProfile(UserProfile profile) {
        return repository.save(profile);
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserProfile> getAllProfiles() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public UserProfile getProfileById(String id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public UserProfile updateProfile(String id, UserProfile updatedProfile) {
        updatedProfile.setId(id);
        return repository.save(updatedProfile);
    }

    @Override
    @Transactional
    public void deleteProfile(String id) {
        repository.deleteById(id);
    }
}

