package br.com.docunha.ecommerce.payment.service;

import java.util.Optional;
import java.util.UUID;

import org.springframework.stereotype.Service;

import br.com.docunha.ecommerce.checkout.event.CheckoutCreatedEvent;
import br.com.docunha.ecommerce.payment.entity.PaymentEntity;
import br.com.docunha.ecommerce.payment.repository.PaymentRespository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService{
    
    private final PaymentRespository paymentRepository;
    
    @Override
    public Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent) {
        final PaymentEntity paymentEntity = PaymentEntity.builder()
                .checkoutCode(checkoutCreatedEvent.getCheckoutCode())
                .code(UUID.randomUUID().toString())
                .build();
        paymentRepository.save(paymentEntity);
        return Optional.of(paymentEntity);
    }

}
