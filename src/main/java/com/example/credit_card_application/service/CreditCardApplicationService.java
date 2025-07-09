package com.example.credit_card_application.service;

import com.example.credit_card_application.dto.CreditCardApplicationDTO;
import com.example.credit_card_application.entity.CreditCardApplication;
import com.example.credit_card_application.repository.CreditCardApplicationRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CreditCardApplicationService {

    @Autowired
    private CreditCardApplicationRepository applicationRepository;

    @Autowired
    private ModelMapper modelMapper;

    public CreditCardApplication submitApplication(CreditCardApplicationDTO applicationDTO) {
        CreditCardApplication application = modelMapper.map(applicationDTO, CreditCardApplication.class);
        application.setApplicationDate(LocalDateTime.now());
        return applicationRepository.save(application);
    }
}