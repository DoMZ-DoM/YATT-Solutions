/**
 * 
 */
package com.yatt.paymentservice.service;

import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;

import com.yatt.paymentservice.dto.PaymentRepository;
import com.yatt.paymentservice.exception.DataNotFoundEXception;
import com.yatt.paymentservice.exception.PaymentFailedException;
import com.yatt.paymentservice.exception.ProfileNotFoundException;
import com.yatt.paymentservice.models.Payment;
import com.yatt.paymentservice.models.Profile;
import com.yatt.paymentservice.utilities.PaymentServiceUtilities;

/**
 * @author ayich
 *
 */

@Service
public class PaymentService {

	private final static Logger LOGGER = Logger.getLogger(PaymentService.class.getName());

	@Autowired
	private PaymentRepository paymentRepo;

	@Autowired
	private RestServiceCaller caller;

	@Value("${core.profile.service:core-profile-serivce}")
	private String profileServiceName;

	@Value("${core.payment.service:core-payment-serivce}")
	private String paymentServiceName;

	@Value("${core.job-fair.service:core-profile-serivce}")
	private String jobFairServiceName;

	@Value("${core.subscription.service:core-subscription-serivce}")
	private String subscriptionServiceName;

	public Payment getPayment(String id, String token) throws DataNotFoundEXception {

		try {
			PaymentServiceUtilities.validate(token);
			Optional<Payment> payment = paymentRepo.findById(id);
			if (payment.isPresent())
				return payment.get();
			else
				throw new DataNotFoundEXception(String.format("Transaction [%s] not found", id));
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, String.format("Error occuried getting payment for the transaction [%s]", id), e);
			e.printStackTrace();
		}
		return null;

	}

	@SuppressWarnings("unused")
	public Payment addPayment(Payment payment, String token) throws PaymentFailedException {

		try {
			PaymentServiceUtilities.validate(token);

			/**
			 * before adding the payment - check if the company is registered and activated.
			 * Call profile service
			 */
			
			Profile profile = caller.call(profileServiceName, HttpMethod.GET, payment.getCompanyId());
			if (null != profile) {
				System.out.println("PROFILE" + profile.toString());
				if (PaymentServiceUtilities.validateProfile(profile)) {
					return paymentRepo.save(payment);
				} else {
					throw new ProfileNotFoundException(String.format("Profile [%s] is not activated", profile));
				}
			} else {
				throw new ProfileNotFoundException(String.format("Failed to find profile %s", profile));
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOGGER.log(Level.SEVERE, String.format("Adding [%s] payment failed ", payment), e); // correlationID - GUID
			throw new PaymentFailedException(String.format("payment failed %s", payment));
		}

	}

}
