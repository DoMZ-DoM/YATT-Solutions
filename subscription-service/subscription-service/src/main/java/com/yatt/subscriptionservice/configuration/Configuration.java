/**
 * 
 */
package com.yatt.subscriptionservice.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.client.RestTemplate;

/**
 * @author ayich
 *
 */

@org.springframework.context.annotation.Configuration
public class Configuration {
	
	
	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	/*
	 * @Bean MongoTemplate getMongoTemplate() { return new MongoTemplate(null); }
	 */

}
