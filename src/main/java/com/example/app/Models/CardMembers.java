package com.example.app.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "card_members")
@Data
@Getter
@Setter
@NoArgsConstructor
public class CardMembers {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "member_id")
    private Long memberId;

    @Column(name = "member_name", length = 50)
    private String memberName;

    @Column(name = "member_email", length = 50)
    private String memberEmail;

    @Column(name = "member_phone_number", length = 20)
    private String memberPhoneNumber;

    @Column(name = "member_address", length = 120)
    private String memberAddress;

    @Column(name = "member_city", length = 50)
    private String memberCity;

    @Column(name = "member_state", length = 50)
    private String memberState;

    @Column(name = "member_country", length = 50)
    private String memberCountry;

    @Column(name = "member_zip_code", length = 20)
    private String memberZipCode;

    @Column(name = "card_number", length = 16)
    private String cardNumber;

    @Column(name = "card_expiry_date")
    private Date cardExpiryDate;

    @Column(name = "card_type", length = 20)
    private String cardType;

    @Column(name = "card_status", length = 10)
    private String cardStatus;

    @Column(name = "acquirer_reference_number", length = 12)
    private String acquirerReferenceNumber;

    @Column(name = "internal_reference_number", length = 12)
    private String internalReferenceNumber;

    @Column(name = "capture_interface", length = 6)
    private String captureInterface;

    @Column(name = "routing_interface", length = 6)
    private String routingInterface;

    @Column(name = "stan_data", length = 6)
    private String stanData;

    @Column(name = "bank_code", length = 5)
    private String bankCode;

    @Column(name = "branch_code", length = 5)
    private String branchCode;

    @Column(name = "business_date")
    private Date businessDate;

    @Column(name = "processing_code", length = 6)
    private String processingCode;

    @Column(name = "authorization_amount")
    private BigDecimal authorizationAmount;

    @Column(name = "authorization_currency", length = 3)
    private String authorizationCurrency;

    @Column(name = "billing_amount")
    private BigDecimal billingAmount;

    @Column(name = "billing_currency", length = 3)
    private String billingCurrency;

    @Column(name = "terminal_number", length = 15)
    private String terminalNumber;

    @Column(name = "terminal_acronym", length = 40)
    private String terminalAcronym;

    @Column(name = "action_code", length = 3)
    private String actionCode;

    @Column(name = "authorization_date")
    private Date authorizationDate;

    @Column(name = "authorization_code", length = 6)
    private String authorizationCode;

    @Column(name = "local_date")
    private Date localDate;

    @Column(name = "autho_flag", length = 1)
    private String authoFlag;

    @Column(name = "chip_flag", length = 1)
    private String chipFlag;

    @Column(name = "matching_status", length = 1)
    private String matchingStatus;

    @Column(name = "matching_date")
    private Date matchingDate;
}
