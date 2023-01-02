package com.yatt.jobservice.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.yatt.jobservice.controller.JobService;
import com.yatt.jobservice.controller.exceptions.ProfileNotFoundException;
import com.yatt.jobservice.jobserviceutilities.JobServiceUtilities;
import com.yatt.jobservice.model.Payment;
import com.yatt.jobservice.model.Payment.paymentStatus;
import com.yatt.jobservice.model.Profile;

@Service
public class JobServiceImpl implements JobService {

	/*
	 * @Autowired JobServiceRestTemplate restTemplate;
	 */
	private final static Logger LOGGER = Logger.getLogger(JobServiceImpl.class.getName());

	@Value("${core.profile.service:core-profile-serivce}")
	private String profileServiceName;

	@Value("${core.payment.service:core-payment-serivce}")
	private String paymentServiceName;

	@Value("${core.job-fair.service:core-profile-serivce}")
	private String jobFairServiceName;

	@Value("${core.subscription.service:core-subscription-serivce}")
	private String subscriptionServiceName;
	@Autowired
	RestTemplate template;

	@Override
	public boolean profileStatus(String companyId) {

		String uri = String.format("http://%s/profile/%s", profileServiceName, companyId);
		try {
			Profile profile = template.getForObject(uri, Profile.class);
			if (profile != null)
			return JobServiceUtilities.validateProfile(profile);
			else {
				throw new ProfileNotFoundException(String.format("Failed to find profile %s", profile));
			}
		} catch (RestClientException e) {
			LOGGER.log(Level.SEVERE,
					String.format("Service call to profile service failed [companyId = %s]", companyId), e);
			e.printStackTrace();
			throw new RestClientException(String.format("call to profile service failed", companyId), e);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public boolean membershipStatus(String companyId) {

		String uri = String.format("http://%s/payment/company/%s", paymentServiceName, companyId);
		try {
			Payment payment = template.getForObject(uri, Payment.class);
			if(payment.getStatus() == paymentStatus.COMPLETE)
				return true;
			else
				return false;
		
		} catch (RestClientException e) {
			LOGGER.log(Level.SEVERE,
					String.format("Service call to profile service failed [companyId = %s]", companyId), e);
			e.printStackTrace();
			throw new RestClientException(String.format("call to profile service failed", companyId), e);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
