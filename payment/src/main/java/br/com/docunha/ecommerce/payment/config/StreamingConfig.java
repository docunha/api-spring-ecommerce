package br.com.docunha.ecommerce.payment.config;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.context.annotation.Configuration;

import br.com.docunha.ecommerce.payment.streaming.CheckoutProcessor;

@Configuration
@EnableBinding(CheckoutProcessor.class)
public class StreamingConfig {
    
}
