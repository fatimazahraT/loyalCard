package com.example.app.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "merchants")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Merchant {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "merchant_id")
    private Long merchantId;

    @Column(name = "merchant_number", unique = true, nullable = false, length = 15)
    private String merchantNumber;

    @Column(name = "merchant_name", nullable = false, length = 40)
    private String merchantName;

    @Column(name = "status_merchant", length = 1)
    private String statusMerchant;

    @Column(name = "status_date")
    private LocalDate statusDate;

    @Column(name = "status_reason", length = 2)
    private String statusReason;

    @Column(name = "merchant_mcc", length = 4)
    private String merchantMcc;

    @Column(name = "merchant_manage_code", length = 3)
    private String merchantManageCode;

    @Column(name = "merchant_commission_code", length = 3)
    private String merchantCommissionCode;

    @Column(name = "type_transaction_supported", length = 1)
    private String typeTransactionSupported;

    @Column(name = "former_commission", length = 3)
    private String formerCommission;

    @Column(name = "date_effective_commission")
    private LocalDate dateEffectiveCommission;

    @Column(name = "contact_name", length = 60)
    private String contactName;

    @Column(name = "legal_id", length = 30)
    private String legalId;

    @Column(name = "mother_tongue", length = 3)
    private String motherTongue;

    @Column(name = "address_1", length = 120)
    private String address1;

    @Column(name = "type_address_1", length = 1)
    private String typeAddress1;

    @Column(name = "city_code_1", length = 5)
    private String cityCode1;

    @Column(name = "country_code_1", length = 3)
    private String countryCode1;

    @Column(name = "address_2", length = 120)
    private String address2;

    @Column(name = "type_address_2", length = 1)
    private String typeAddress2;

    @Column(name = "city_code_2", length = 5)
    private String cityCode2;

    @Column(name = "country_code_2", length = 3)
    private String countryCode2;

    @Column(name = "address_3", length = 120)
    private String address3;

    @Column(name = "type_address_3", length = 1)
    private String typeAddress3;

    @Column(name = "city_code_3", length = 5)
    private String cityCode3;

    @Column(name = "country_code_3", length = 3)
    private String countryCode3;

    @Column(name = "mobile_number", length = 30)
    private String mobileNumber;

    @Column(name = "work_phone_number", length = 30)
    private String workPhoneNumber;

    @Column(name = "home_phone_number", length = 30)
    private String homePhoneNumber;

    @Column(name = "record_origine", length = 1)
    private String recordOrigine;

    @Column(name = "last_action_code", length = 1)
    private String lastActionCode;

    @Column(name = "last_action_date")
    private LocalDate lastActionDate;

    @Column(name = "last_action_user", length = 64)
    private String lastActionUser;

    @Column(name = "merchant_accounts", length = 1060)
    private String merchantAccounts;

    @Column(name = "supplementary_data_1", length = 200)
    private String supplementaryData1;

    @Column(name = "supplementary_data_2", length = 200)
    private String supplementaryData2;

    @Column(name = "user_capturing", length = 64)
    private String userCapturing;

    @Column(name = "dur_pre_auth")
    private Integer durPreAuth;

    @Column(name = "network_accepted", length = 20)
    private String networkAccepted;

    @Column(name = "email_address", length = 50)
    private String emailAddress;

    @Column(name = "website", length = 50)
    private String website;

    @Column(name = "land_mark", length = 50)
    private String landMark;
    @Column(name = "registered_location", length = 50)
    private String registeredLocation;
}