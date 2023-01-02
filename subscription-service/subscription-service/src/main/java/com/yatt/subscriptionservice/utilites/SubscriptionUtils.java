package com.yatt.subscriptionservice.utilites;

import com.yatt.subscriptionservice.exceptions.InvalidTokenException;

public class SubscriptionUtils {
	
	
	public static boolean validate(String token) throws InvalidTokenException {
		String [] tokens = token.split(" ");
		System.out.println(tokens[0]);
		if (!tokens[0].equals("Bearer") || tokens.length < 2 ) {
			throw new InvalidTokenException(String.format("Missing Bearer in the token [%s]", token));
			
		}
		return true;
	}

}
