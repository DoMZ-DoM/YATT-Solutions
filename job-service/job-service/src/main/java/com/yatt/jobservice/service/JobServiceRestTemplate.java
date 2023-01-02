package com.yatt.jobservice.service;

import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.web.client.RestTemplate;
public class JobServiceRestTemplate implements RestTemplateCustomizer{

	@Override
	public void customize(RestTemplate restTemplate) {
		
		restTemplate.getInterceptors().add(new CustomClientHttpRequestInterceptor());
	}

}
