package com.yatt.jobservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yatt.jobservice.controller.exceptions.JobExitsExceptions;
import com.yatt.jobservice.controller.exceptions.ProfileStatusException;
import com.yatt.jobservice.dto.JobServiceRepo;
import com.yatt.jobservice.model.Job;
import com.yatt.jobservice.service.JobServiceImpl;

@RestController
public class JobServiceController {

	private JobServiceRepo repo;

	@Autowired
	private JobServiceImpl service;

	public JobServiceController(JobServiceRepo repo) {
		this.repo = repo;
	}

	/**
	 * UI can use as SAVE for later
	 * 
	 * @param newJob
	 * @param companyId
	 * @param jobId
	 * @return
	 * @throws JobExitsExceptions
	 * @throws ProfileStatusException /company/{companyId}/job/create/{jobId}
	 */
	@PostMapping("/company/{companyId}/job/create/{jobId}")
	Job addJob(@RequestBody Job newJob, @PathVariable String companyId, @PathVariable String jobId)
			throws JobExitsExceptions, ProfileStatusException {
		// check the profile, we need profile object, company id
		if (service.profileStatus(companyId)) {
			repo.save(newJob);
		} else {
			throw new ProfileStatusException(String.format("Profile is not active :%s", companyId));
		}
		return newJob;
	}

	@DeleteMapping("/job/delete/{jobId}")
	void deleteJob(@RequestBody Job newJob, @PathVariable String jobId) throws JobExitsExceptions {
		repo.delete(newJob);
	}

	@GetMapping("/job/{jobId}")
	Job getJob(@RequestBody Job newJob, @PathVariable String jobId) throws JobExitsExceptions {
		return repo.findByJobId(jobId);
	}

	@GetMapping("/jobs")
	List<Job> getAllJobs() throws JobExitsExceptions {
		return repo.findAll();
	}

	/*
	 * possible bug here if the company has already passed subscription and tried to
	 * update do we constriant him or not
	 */
	@PutMapping("company/{companyId}/job/update/{jobid}")
	Job updateJob(@RequestBody Job updateJob, @PathVariable String companyId, @PathVariable String jobId) {
		return null;

	}

	@PostMapping("company/{companyId}/job/publish/{jobId}")
	Job publishJob(@RequestBody Job publishJob, @PathVariable String companyId, @PathVariable String jobId)
			throws JobExitsExceptions {
		if (service.profileStatus(companyId) && service.membershipStatus(companyId)) {
			/*
			 * find the job and change the status, publish status Get job with job id, save
			 * the status true for isPublishable return 200, But on the job feed check the
			 * publishable status if true go thru it otherwise skip it
			 */

			Job job = null;
			try {
				job = repo.findByJobId(jobId);
				if (job != null) {
					if (service.profileStatus(companyId) && service.membershipStatus(companyId)) {
						job.setSearchable(true);
						job.setFeedReady(true);
						job.setPublishStatus(true);
						repo.save(job);
					} else {
						throw new ProfileStatusException(String.format("Profile is not active :%s", companyId));
					}
					
				} else {
					if (service.profileStatus(companyId) && service.membershipStatus(companyId)) {
						publishJob.setSearchable(true);
						publishJob.setFeedReady(true);
						publishJob.setPublishStatus(true);
						repo.save(publishJob);
					} else {
						throw new ProfileStatusException(String.format("Profile is not active :%s", companyId));
					}
					
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			job.setPublishStatus(true);
			return repo.save(job);
		}
		return null;
	}
}
