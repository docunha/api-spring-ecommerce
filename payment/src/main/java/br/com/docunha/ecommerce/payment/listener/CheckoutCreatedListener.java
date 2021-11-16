package br.com.docunha.ecommerce.payment.listener;

import java.util.UUID;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import br.com.docunha.ecommerce.checkout.event.CheckoutCreatedEvent;
import br.com.docunha.ecommerce.payment.entity.PaymentEntity;
import br.com.docunha.ecommerce.payment.event.PaymentCreatedEvent;
import br.com.docunha.ecommerce.payment.service.PaymentService;
import br.com.docunha.ecommerce.payment.streaming.CheckoutProcessor;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CheckoutCreatedListener {
    
    private final CheckoutProcessor checkoutProcessor;
    private final PaymentService paymentService;

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(CheckoutCreatedEvent checkoutCreatedEvent){
        final PaymentEntity paymentEntity = paymentService.create(checkoutCreatedEvent).orElseThrow();
        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
            .setCheckoutCode(paymentEntity.getCheckoutCode())
            .setPaymentCode(paymentEntity.getCode())
            .build();
        checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());
    }
}
