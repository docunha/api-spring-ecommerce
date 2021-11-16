package br.com.docunha.ecommerce.checkout.service;

import java.util.Optional;

import br.com.docunha.ecommerce.checkout.entity.CheckoutEntity;
import br.com.docunha.ecommerce.checkout.resource.checkout.CheckoutRequest;

public interface CheckoutService {
    
    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

    Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status);
}
