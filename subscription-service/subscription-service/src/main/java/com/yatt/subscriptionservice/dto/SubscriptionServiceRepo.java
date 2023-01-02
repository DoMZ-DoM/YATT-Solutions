package com.yatt.subscriptionservice.dto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yatt.subscriptionservice.model.Plan;
@Repository
public interface SubscriptionServiceRepo extends MongoRepository<Plan,String> {
}
