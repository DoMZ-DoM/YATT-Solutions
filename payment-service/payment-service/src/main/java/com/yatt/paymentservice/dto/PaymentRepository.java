/**
 * 
 */
package com.yatt.paymentservice.dto;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.yatt.paymentservice.models.Payment;

/**
 * @author ayich
 *
 */
@Repository
public interface PaymentRepository extends MongoRepository<Payment, String> {

	Optional<Payment> findById(String id);
}
