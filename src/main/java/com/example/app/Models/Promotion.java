package com.example.app.Models;


import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "promotions")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "PROMOTION_ID")
    private Long promotionId;

    @Column(name = "PROMOTION_NAME")
    private String promotionName;
    @Column(name = "MERCHANT_CODE")
    private String merchantCode;


    @Column(name = "PROMOTION_DESCRIPTION")
    private String promotionDescription;

    @Column(name = "START_DATE")
    private Date startDate;

    @Column(name = "END_DATE")
    private Date endDate;

    @Column(name = "DISCOUNT_AMOUNT")
    private Double discountAmount;

    @Column(name = "PROMOTION_PERCENTAGE")
    private Double promotionPercentage;

    @Column(name = "PROMOTION_CODE")
    private String promotionCode;

    @Column(name = "MIN_QUANTITY")
    private Integer minQuantity;

    @Column(name = "MAX_QUANTITY")
    private Integer maxQuantity;

    @Column(name = "MIN_PRICE")
    private Double minPrice;

    @Column(name = "MAX_PRICE")
    private Double maxPrice;

    @Column(name = "IS_ACTIVE")
    private Character isActive;

    @Column(name = "VALID_FOR_MEMBERSHIP")
    private Character validForMembership;

    @Column(name = "VALID_FOR_NEW_CUSTOMERS")
    private Character validForNewCustomers;

    @Column(name = "VALID_FOR_EXISTING_CUSTOMERS")
    private Character validForExistingCustomers;

}