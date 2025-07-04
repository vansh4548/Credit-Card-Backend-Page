package com.example.credit_card_application.controller;

import com.example.credit_card_application.dto.CreditCardApplicationDTO;
import com.example.credit_card_application.entity.CreditCardApplication;
import com.example.credit_card_application.service.CreditCardApplicationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/credit-card")
public class CreditCardApplicationController {

    @Autowired
    private CreditCardApplicationService applicationService;

    @PostMapping("/apply")
    public ResponseEntity<CreditCardApplication> submitApplication(
            @Valid @RequestBody CreditCardApplicationDTO applicationDTO) {
        CreditCardApplication application = applicationService.submitApplication(applicationDTO);
        return ResponseEntity.ok(application);
    }
}