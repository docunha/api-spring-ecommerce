package br.com.docunha.ecommerce.payment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.docunha.ecommerce.payment.entity.PaymentEntity;

public interface PaymentRespository extends JpaRepository<PaymentEntity, Long> {
    
}
