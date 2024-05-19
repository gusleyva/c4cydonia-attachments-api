package com.c4cydonia.attachments.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.c4cydonia.attachments.model.UserProfile;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
}