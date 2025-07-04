package com.example.credit_card_application.repository;

import com.example.credit_card_application.entity.CreditCardApplication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardApplicationRepository extends JpaRepository<CreditCardApplication, Long> {
}