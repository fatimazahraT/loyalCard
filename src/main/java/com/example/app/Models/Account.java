package com.example.app.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "Account")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Account {

    @Id
    @Column(name = "Account_number", length = 22)
    private String accountNumber;

    @Column(name = "Entity", length = 1)
    private String entity;

    @Column(name = "Bank_code", length = 5)
    private String bankCode;

    @Column(name = "Branch_code", length = 5)
    private String branchCode;

    @Column(name = "User_id", length = 24)
    private String userId;

    @Column(name = "Program_index", length = 3)
    private String programIndex;

    @Column(name = "Program_redemeption", length = 3)
    private String programRedemption;



    @Column(name = "Balance_trx_previous_month", precision = 12, scale = 3)
    private BigDecimal balanceTrxPreviousMonth;

    @Column(name = "Balance_points_current_month", precision = 8)
    private BigDecimal balancePointsCurrentMonth;

    @Column(name = "Balance_points_previous_month", precision = 8)
    private BigDecimal balancePointsPreviousMonth;

    @Column(name = "Balance_trx_current_month", precision = 12, scale = 3)
    private BigDecimal balanceTrxCurrentMonth;

    @Column(name = "Reedeemed_points", precision = 8)
    private BigDecimal redeemedPoints;

    @Column(name = "Balance_points", precision = 8)
    private BigDecimal balancePoints;

    @Column(name = "Welcome_points", precision = 8)
    private BigDecimal welcomePoints;

    @Column(name = "Balance_transaction", precision = 12)
    private BigDecimal balanceTransaction;

    @Column(name = "Status_date")
    private Date statusDate;

    @Column(name = "Status", length = 1)
    private String status;

    @Column(name = "Memo", length = 200)
    private String memo;

    @Column(name = "Country", length = 3)
    private String country;

    @Column(name = "City", length = 5)
    private String city;

    @Column(name = "Address", length = 120)
    private String address;

    @Column(name = "Redeemed_type", length = 1)
    private String redeemedType;

    @Column(name = "Birth_date")
    private Date birthDate;

    @Column(name = "First_name", length = 26)
    private String firstName;

    @Column(name = "Family_name", length = 26)
    private String familyName;

    @Column(name = "Currency", length = 3)
    private String currencyCode;

    @Column(name = "Entity_ID", length = 24)
    private String entityId;

    @Column(name = "Creation_date")
    private Date creationDate;

    @Column(name = "Creation_user", length = 15)
    private String creationUser;

    @Column(name = "Last_update_date")
    private Date lastUpdateDate;

    @Column(name = "Monthly_cutoff_date")
    private Date monthlyCutoffDate;

    @Column(name = "Update_type", length = 1)
    private String updateType;

    @Column(name = "Update_user", length = 15)
    private String updateUser;


}
