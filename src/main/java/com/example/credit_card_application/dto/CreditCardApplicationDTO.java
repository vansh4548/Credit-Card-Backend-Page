package com.example.credit_card_application.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.util.Date;

@Data
public class CreditCardApplicationDTO {

    @NotBlank(message = "Full name is required")
    private String fullName;

    @NotBlank(message = "Mother's name is required")
    private String motherName;

    @NotNull(message = "Date of birth is required")
    private Date dateOfBirth;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @Pattern(regexp = "^[0-9]{10}$", message = "Alternate mobile number must be 10 digits")
    private String alternateMobileNumber;

    @NotBlank(message = "Aadhaar number is required")
    @Pattern(regexp = "^[0-9]{12}$", message = "Aadhaar number must be 12 digits")
    private String aadhaarNumber;

    @NotBlank(message = "PAN is required")
    @Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "PAN must be in valid format")
    private String panNumber;

    @NotBlank(message = "Address is required")
    private String fullAddress;

    @NotBlank(message = "PIN code is required")
    @Pattern(regexp = "^[0-9]{6}$", message = "PIN code must be 6 digits")
    private String pinCode;

    @NotBlank(message = "State is required")
    private String state;

    @NotNull(message = "Annual income is required")
    @Min(value = 0, message = "Annual income must be positive")
    private Double annualIncome;

    private String previousIssuer;
    private Double previousCardLimit;
    private String referralCode;
}