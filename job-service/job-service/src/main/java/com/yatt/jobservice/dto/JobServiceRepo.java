package com.yatt.jobservice.dto;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.yatt.jobservice.model.Job;


public interface JobServiceRepo extends MongoRepository<Job, String> {

	Job findByJobId(String jobId);

}
