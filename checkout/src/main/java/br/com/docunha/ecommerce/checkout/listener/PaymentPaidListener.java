package br.com.docunha.ecommerce.checkout.listener;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import br.com.docunha.ecommerce.checkout.entity.CheckoutEntity;
import br.com.docunha.ecommerce.checkout.service.CheckoutService;
import br.com.docunha.ecommerce.checkout.streaming.PaymentPaidSink;
import br.com.docunha.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutService checkoutService;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent paymentCreatedEvent){
        checkoutService.updateStatus(paymentCreatedEvent.getCheckoutCode().toString(), CheckoutEntity.Status.APPROVED);
    }
}
