/**
 * 
 */
package com.yatt.subscriptionservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.yatt.subscriptionservice.dto.SubscriptionServiceRepo;
import com.yatt.subscriptionservice.exceptions.InvalidTokenException;
import com.yatt.subscriptionservice.exceptions.UnsupportedPlanException;
import com.yatt.subscriptionservice.model.Plan;
import com.yatt.subscriptionservice.model.Plan.Type;
import com.yatt.subscriptionservice.utilites.SubscriptionUtils;

/**
 * @author ayich
 *
 */
@Service
public class SubscriptionServices {
	
	@Autowired
	private SubscriptionServiceRepo subRepo;
	
	@Autowired
	private RestServiceCaller caller;

	@Value("${core.payment.service:core-payment-serivce}")
	private String paymentServiceName;
	@Value("{$core.profile.service:core-profile-serivce}")
	private String profileServiceName; 
	@Value("{$core.job-fair.service:core-profile-serivce}")
	private String jobFairServiceName; 
	@Value("{$core.subscription.service:core-subscription-serivce}")
	private String subscriptionServiceName; 
	
	public List<Plan> getSupportedPlans(String token) throws UnsupportedPlanException, InvalidTokenException {

		// validate the token
		if (SubscriptionUtils.validate(token)) {
			List<Plan> plans = new ArrayList<Plan>() {
				/**
				 * 
				 */
				private static final long serialVersionUID = 1L;

				{
					add(new Plan(Plan.Type.TRAIL));
					add(new Plan(Plan.Type.STANDARD));
					add(new Plan(Plan.Type.PREMIUM));
				}
			};
			return plans;
		} else {
			throw new InvalidTokenException(String.format("Token validation failed [%s] ", token));
		}
	}

	/**
	 * This is automated flow - make call to payment service to get the status and plan type.
	 * @param type
	 * @param companyId
	 * @param planId
	 * @param token
	 * @throws InvalidTokenException
	 */
	public void subscribe(Type type, String companyId, String planId, String token) throws InvalidTokenException {
		
		if (SubscriptionUtils.validate(token)) {
			caller.call(paymentServiceName, HttpMethod.GET, companyId, planId);
		} else {
			throw new InvalidTokenException(String.format("Token validation failed [%s] ", token));
		}
		
	}

	/**
	 * This is a manual flow. Admin need to enter transaction number then call payment method and validate the transactionId 
	 * @param type
	 * @param companyId
	 * @param planId
	 * @param adminId
	 * @param token
	 * @throws InvalidTokenException
	 */
	public void subscribe(Type type, String companyId, String planId, String adminId, String transcationId, String token) throws InvalidTokenException {

		
		if (SubscriptionUtils.validate(token)) {
			// call payment service - think of service to service authentication - GAP
			caller.call(paymentServiceName, HttpMethod.GET, companyId, planId, adminId,transcationId);
			
		} else {
			throw new InvalidTokenException(String.format("Token validation failed [%s] ", token));
		}
	}

}
