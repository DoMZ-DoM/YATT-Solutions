package com.yatt.profileservice.controller;

import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.client.result.UpdateResult;
import com.yatt.profileservice.dto.ProfileRepository;
import com.yatt.profileservice.profile.model.Profile;

@RestController
public class ProfileServiceController {
	private final static Logger LOGGER = Logger.getLogger(ProfileServiceController.class.getName());

	private ProfileRepository profileService;
	private MongoTemplate mongoTemplate;

	public ProfileServiceController(ProfileRepository profileService, MongoTemplate mongoTemplate) {
		this.profileService = profileService;
		this.mongoTemplate = mongoTemplate;
	}

	@GetMapping("/profiles")
	List<Profile> all() {

		return profileService.findAll();

	}

	@PostMapping("/profile/{id}")
	Profile newEmployee(@RequestBody Profile newProfile, @PathVariable String id)
			throws Exception {
		LOGGER.log(Level.FINE, "::profile::{}", newProfile.toString());
		
		Optional<Profile> profile = profileService.findById(id);
	
		if (!profile.isEmpty()) {
			throw new Exception("Profile already exists");
		}
		Profile savedEmployee = profileService.save(newProfile);
		
		return savedEmployee;
	}

	@GetMapping("/profile/{id}")
	Profile one(@PathVariable String id) throws Exception {
		LOGGER.log(Level.FINE, "::GET profile id::{}", id);
		return profileService.findById(id).orElseThrow(() -> new Exception("profile not found"));

	}

	@PutMapping("/profile/{id}")
	UpdateResult updateProfile(@RequestBody Profile newProfile, @PathVariable String id) {
		LOGGER.log(Level.FINE, "::PUT profile id::{}", id);
		LOGGER.log(Level.FINE, "::PUT profile ::{}", newProfile);
		Query query = new Query();
		query.addCriteria(Criteria.where("id").is(id));
		Update update = new Update();
		return mongoTemplate.upsert(query, update, Profile.class);

	}

	@DeleteMapping("/profile/{id}")
	void deleteEmployee(@PathVariable String id) {
		
		LOGGER.log(Level.INFO, "::Delete profile id:: {}", id);
		profileService.deleteById(id);
	}

}
