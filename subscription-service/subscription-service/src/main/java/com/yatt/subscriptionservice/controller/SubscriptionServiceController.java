package com.yatt.subscriptionservice.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.google.common.net.HttpHeaders;
import com.yatt.subscriptionservice.exceptions.InvalidTokenException;
import com.yatt.subscriptionservice.exceptions.UnsupportedPlanException;
import com.yatt.subscriptionservice.model.Plan;
import com.yatt.subscriptionservice.services.SubscriptionServices;

@RestController
public class SubscriptionServiceController {

	@Autowired
	private SubscriptionServices subServices;
	private final static Logger LOGGER = Logger.getLogger(SubscriptionServiceController.class.getName());

	/**
	 * an endpoint for admins of YATT to add new subscriptions plans
	 */

	@PostMapping("/yatt/admin/{adminId}")
	Plan addSubscriptionPlans(@RequestBody Plan plans, @PathVariable String adminId, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) {
		LOGGER.log(Level.INFO, String.format("admininstrator [%s] added new plans [%s]", adminId, plans));

		/**
		 * validate token - singed by our cert After checking the validity of the
		 * request add the plan into database
		 */

		return null;
	}

	/**
	 * returns all the subscription YATT has
	 * 
	 * @throws UnsupportedPlanException
	 * @throws InvalidTokenException 
	 */
	@GetMapping("/subscriptions")
	List<Plan> getSubscriptionPlans(@RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) throws UnsupportedPlanException, InvalidTokenException {
		// validate token
		return subServices.getSupportedPlans(authorization);
	}
	
	@PostMapping("/subscription/company/{companyId}/plan/{planId}")
	Plan subscribeAutomated(Plan.Type type, @PathVariable String companyId, @PathVariable String planId, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) throws InvalidTokenException {
		LOGGER.log(Level.INFO, String.format("::automated flow:: company [%s] started subscription of planId [%s]", companyId, planId));

		
		/**
		 * validate token - singed by our cert After checking the validity of the
		 * request add the plan into database
		 */

		subServices.subscribe(type, companyId, planId, authorization);
		
		return null;
	}
	
	/**
	 * used by admin to manually enter the subscription for a company - token provided here is admin token
	 * @param type
	 * @param companyId
	 * @param planId
	 * @param adminId
	 * @param authorization
	 * @param transcationId
	 * @return
	 * @throws InvalidTokenException
	 */
	@PostMapping("/subscription/company/{companyId}/plan/{planId}/admin/{adminId}")
	Plan subscribeAdmin(Plan.Type type, @PathVariable String companyId,@PathVariable String planId,@PathVariable String adminId, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization, String transcationId) throws InvalidTokenException {
		LOGGER.log(Level.INFO, String.format("::manual admin flow:: admininstrator [%s] started subscription of planId [%s] for company [%s]", adminId, planId,adminId));

		/**
		 * validate token - singed by our cert After checking the validity of the
		 * request add the plan into database
		 */
		subServices.subscribe(type, companyId, planId,adminId,transcationId, authorization);

		return null;
	}
}
