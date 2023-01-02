/**
 * 
 */
package com.yatt.paymentservice.controller;

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
import com.yatt.paymentservice.exception.DataNotFoundEXception;
import com.yatt.paymentservice.exception.InvalidTokenException;
import com.yatt.paymentservice.exception.PaymentFailedException;
import com.yatt.paymentservice.exception.UnsupportedPlanException;
import com.yatt.paymentservice.models.Payment;
import com.yatt.paymentservice.service.PaymentService;

/**
 * @author ayich
 *
 */

@RestController
public class PaymentServiceController {
	private final static Logger LOGGER = Logger.getLogger(PaymentServiceController.class.getName());
	
	@Autowired
	private PaymentService paymentService;
	
	
	@GetMapping("payment/company/{companyId}")
	Payment getPaymentDetail(@PathVariable String companyId, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) throws UnsupportedPlanException, InvalidTokenException, DataNotFoundEXception {
		// validate token
		return paymentService.getPayment(companyId,"Bearer sflksdlfjh");
	}
	
	@PostMapping("/payment")
	Payment addPayment(@RequestBody Payment payment, @RequestHeader(HttpHeaders.AUTHORIZATION) String authorization) throws InvalidTokenException, PaymentFailedException {
		LOGGER.log(Level.INFO, String.format("::manual flow PaymentServiceController :: company adding payment for planId"));

		/**
		 * validate token - singed by our cert After checking the validity of the
		 * request add the plan into database
		 */
		return paymentService.addPayment(payment, authorization);
	}

}
