package com.yatt.paymentservice.utilities;

import com.yatt.paymentservice.exception.InvalidTokenException;
import com.yatt.paymentservice.models.Profile;

public class PaymentServiceUtilities {

	public static boolean validate(String token) throws InvalidTokenException {

		String[] tokens = token.split(" ");
		if (!tokens[0].equals("Bearer") || tokens.length < 2) {
			throw new InvalidTokenException(String.format("Missing Bearer in the token [%s]", token));

		}
		return true;
	}

	public static boolean validateProfile(Profile profile) {
		
		if (profile.getActivated())
			return true;
		return false;

	}
}
