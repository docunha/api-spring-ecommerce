package br.com.docunha.ecommerce.payment.service;

import java.util.Optional;

import br.com.docunha.ecommerce.checkout.event.CheckoutCreatedEvent;
import br.com.docunha.ecommerce.payment.entity.PaymentEntity;

public interface PaymentService {
    
    Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent);

}
