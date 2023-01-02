package com.yatt.profileservice.dto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yatt.profileservice.profile.model.Profile;

@Repository
public interface ProfileRepository extends MongoRepository<Profile, String> {

}
