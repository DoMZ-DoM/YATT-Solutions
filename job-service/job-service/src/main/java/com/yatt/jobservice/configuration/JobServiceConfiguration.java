package com.yatt.jobservice.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.yatt.jobservice.service.JobServiceRestTemplate;

@Configuration
public class JobServiceConfiguration {
	
	@Bean
	public JobServiceRestTemplate customRestTemplateCustomizer() {
	    return new JobServiceRestTemplate();
	}
	
	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
