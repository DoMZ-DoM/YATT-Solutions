package com.yatt.jobservice.filter;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ValidationFilter implements Filter {
	private final static Logger LOGGER = Logger.getLogger(ValidationFilter.class.getName());

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		LOGGER.info(String.format("Starting processing for req : {}" + req));

		chain.doFilter(request, response);
		LOGGER.info(String.format("Committing a transaction for req : {}" + req));
	}

}
