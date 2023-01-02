package com.yatt.subscriptionservice.services;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.yatt.subscriptionservice.model.Payment;


/**
 * 
 * @author ayich Rest Service caller
 */
@Service
public class RestServiceCaller {

	private final static Logger LOGGER = Logger.getLogger(RestServiceCaller.class.getName());

	@Autowired
	private RestTemplate restTemplate;

	public Payment call(String serviceName, HttpMethod httpMethod, String companyId, String planId) {

		return restTemplate.getForObject("http://serviceName", Payment.class);

	}

	public Payment call(String paymentServiceName, HttpMethod httpMethod, String companyId, String planId,
			String adminId, String transcationId) {
		/**
		 * uri to get transaction status -
		 * payment/company/{companyId}/transactionId/{transactionId}
		 */
		try {
			return restTemplate.getForObject(String.format("http://%s/payment/company/%s/transactionId/%s",
					paymentServiceName, companyId, transcationId), Payment.class);
		} catch (RestClientException e) {
			LOGGER.log(Level.SEVERE,
					String.format("Service call to payment service failed companyId= %s, transactionId, %s", companyId,
							transcationId),
					e);
			e.printStackTrace();
		}
		return null;
	}

}
