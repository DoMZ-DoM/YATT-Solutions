package com.yatt.paymentservice.service;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.yatt.paymentservice.models.Profile;

/**
 * 
 * @author ayich Rest Service caller
 */
@Service
public class RestServiceCaller {

	private final static Logger LOGGER = Logger.getLogger(RestServiceCaller.class.getName());

	@Autowired
	private RestTemplate restTemplate;


	public Profile call(String serviceName, HttpMethod httpMethod, String companyId, String planId) {

		String o = restTemplate.getForObject("http://serviceName", String.class);
		System.out.println("Object retrieve " + o);

		return null;

	}

	public Profile call(String profileServiceName, HttpMethod httpMethod, String companyId) {
		/**
		 * uri to get profile status - /profile/{id}
		 */
		try {
			String uri = String.format("http://%s/profile/%s", profileServiceName, companyId);
			return restTemplate.getForObject(uri, Profile.class);
		} catch (RestClientException e) {
			LOGGER.log(Level.SEVERE,
					String.format("Service call to profile service failed [companyId = %s]", companyId), e);
			e.printStackTrace();
			throw new RestClientException(String.format("call to profile service failed", companyId), e);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
