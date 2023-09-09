package com.example.app.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Transaction")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "Entity", length = 1)
    private String entity;

    @Column(name = "ARN", length = 23)
    private String arn;

    @Column(name = "Sequence")
    private Integer sequence;

    @Column(name = "Bank_code", length = 5)
    private String bankCode;

    @Column(name = "Branch_code", length = 5)
    private String branchCode;

    @Column(name = "User_id", length = 24)
    private String userId;

    @Column(name = "Transaction_amount", precision = 12, scale = 3)
    private BigDecimal transactionAmount;

    @Column(name = "Transaction_currency", length = 3)
    private String transactionCurrency;

    @Column(name = "Billing_amount", precision = 12, scale = 3)
    private BigDecimal billingAmount;

    @Column(name = "Billing_currency", length = 3)
    private String billingCurrency;

    @Column(name = "Local_amount", precision = 12, scale = 3)
    private BigDecimal localAmount;

    @Column(name = "Local_currency", length = 3)
    private String localCurrency;

    @Column(name = "Authorized_indicator", length = 1)
    private String authorizedIndicator;

    @Column(name = "Transaction_origin", length = 1)
    private String transactionOrigin;

    @Column(name = "Transaction_date")
    private Date transactionDate;

    @Column(name = "Product_code", length = 3)
    private String productCode;

    @Column(name = "Product_type", length = 1)
    private String productType;

    @Column(name = "Network_type", length = 2)
    private String networkType;

    @Column(name = "Currency_indicator", length = 1)
    private String currencyIndicator;

    @Column(name = "Card_origin", length = 1)
    private String cardOrigin;

    @Column(name = "Transaction_code", length = 2)
    private String transactionCode;

    @Column(name = "Transaction_type", length = 1)
    private String transactionType;

    @Column(name = "Merchant_Management", length = 3)
    private String merchantManagementCode;

    @Column(name = "Merchant_number", length = 15)
    private String merchantNumber;

    @Column(name = "Merchant_acronym", length = 40)
    private String merchantAcronym;

    @Column(name = "MCC", length = 4)
    private String merchantCategoryCode;

    @Column(name = "Processing_flag", length = 1)
    private String processingFlag;

    @Column(name = "Date_processing")
    private Date dateProcessing;

    @Column(name = "Number_processing", length = 6)
    private String numberProcessing;

    @Column(name = "Point_generated")
    private Integer pointGenerated;

    @Column(name = "Log_date")
    private Date logDate;

    @Column(name = "Sign_trx", length = 1)
    private String signTransaction;

}
