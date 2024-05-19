package com.c4cydonia.attachments.service;


import java.util.List;

import com.c4cydonia.attachments.model.UserProfile;

public interface IUserProfileService {
    UserProfile createProfile(UserProfile profile);
    List<UserProfile> getAllProfiles();
    UserProfile getProfileById(String id);
    UserProfile updateProfile(String id, UserProfile updatedProfile);
    void deleteProfile(String id);
}