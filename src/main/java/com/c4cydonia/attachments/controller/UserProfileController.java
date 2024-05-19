package com.c4cydonia.attachments.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.c4cydonia.attachments.model.UserProfile;
import com.c4cydonia.attachments.service.IUserProfileService;

@RestController
@RequestMapping("/v1/api/profiles")
public class UserProfileController {

    private final IUserProfileService userProfileService;

    public UserProfileController(IUserProfileService userProfileService) {
        this.userProfileService = userProfileService;
    }

    @PostMapping
    public UserProfile createProfile(@RequestBody UserProfile profile) {
        return userProfileService.createProfile(profile);
    }

    @GetMapping
    public List<UserProfile> getAllProfiles() {
        return userProfileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public UserProfile getProfileById(@PathVariable String id) {
        return userProfileService.getProfileById(id);
    }

    @PutMapping("/{id}")
    public UserProfile updateProfile(@PathVariable String id, @RequestBody UserProfile updatedProfile) {
        return userProfileService.updateProfile(id, updatedProfile);
    }

    @DeleteMapping("/{id}")
    public void deleteProfile(@PathVariable String id) {
        userProfileService.deleteProfile(id);
    }
}
