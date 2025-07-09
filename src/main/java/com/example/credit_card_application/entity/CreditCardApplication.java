package com.example.credit_card_application.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "credit_card_applications",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "aadhaarNumber"),
                @UniqueConstraint(columnNames = "panNumber"),
                @UniqueConstraint(columnNames = "mobileNumber"),
                @UniqueConstraint(columnNames = "email")
        })
public class CreditCardApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Full name is required")
    @Column(name = "full_name")
    private String fullName;

    @NotBlank(message = "Mother's name is required")
    @Column(name = "mother_name")
    private String motherName;

    @NotNull(message = "Date of birth is required")
    @Past(message = "Date of birth must be in the past")
    @Column(name = "date_of_birth")
    private Date dateOfBirth;

    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    @Column(name = "email")
    private String email;

    @NotBlank(message = "Mobile number is required")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    @Column(name = "mobile_number")
    private String mobileNumber;

    @Pattern(regexp = "^[0-9]{10}$", message = "Alternate mobile number must be 10 digits")
    @Column(name = "alternate_mobile_number")
    private String alternateMobileNumber;

    @NotBlank(message = "Aadhaar number is required")
    @Pattern(regexp = "^[0-9]{12}$", message = "Aadhaar number must be 12 digits")
    @Column(name = "aadhaar_number")
    private String aadhaarNumber;

    @NotBlank(message = "PAN is required")
    @Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]{1}$", message = "PAN must be in valid format")
    @Column(name = "pan_number")
    private String panNumber;

    @NotBlank(message = "Address is required")
    @Column(name = "full_address")
    private String fullAddress;

    @NotBlank(message = "PIN code is required")
    @Pattern(regexp = "^[0-9]{6}$", message = "PIN code must be 6 digits")
    @Column(name = "pin_code")
    private String pinCode;

    @NotBlank(message = "State is required")
    @Column(name = "state")
    private String state;

    @NotNull(message = "Annual income is required")
    @Min(value = 0, message = "Annual income must be positive")
    @Column(name = "annual_income")
    private Double annualIncome;

    @Column(name = "previous_issuer")
    private String previousIssuer;

    @Column(name = "previous_card_limit")
    private Double previousCardLimit;

    @Column(name = "referral_code")
    private String referralCode;

    @Column(name = "application_date", updatable = false)
    @CreationTimestamp
    private LocalDateTime applicationDate;

    @PrePersist
    protected void onCreate() {
        applicationDate = LocalDateTime.now();
    }

    @Column(name = "status")
    private String status = "PENDING";
}