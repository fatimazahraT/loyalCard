package com.example.app.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "clients")
@Data
@Getter
@Setter
@NoArgsConstructor
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "CLIENT_ID")
    private Long clientId;

    @Column(name = "CLIENT_CODE")
    private String clientCode;

    @Column(name = "CLIENT_NAME")
    private String clientName;

    @Column(name = "CLIENT_TYPE")
    private String clientType;

    @Column(name = "CLIENT_BANK_CODE")
    private String clientBankCode;

    @Column(name = "CLIENT_BRANCH_CODE")
    private String clientBranchCode;

    @Column(name = "NUMBER_OF_TRIES")
    private Integer numberOfTries;

    @Column(name = "NUMBER_OF_TRIES_ALLOWED")
    private Integer numberOfTriesAllowed;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "CONNECTED")
    private String connected;

    @Column(name = "FIRST_CONNECTION")
    private String firstConnection;

    @Column(name = "NBRE_SESSION_ALLOWED")
    private Integer numberOfSessionAllowed;

    @Column(name = "NBRE_SESSION_CONNECTED")
    private Integer numberOfSessionConnected;

    @Column(name = "LENGTH_PASSWORD")
    private Integer passwordLength;

    @Column(name = "COMPLEXITY_FLAG")
    private String complexityFlag;

    @Column(name = "EXPIRATION_PASSWORD")
    private Integer passwordExpiration;

    @Column(name = "DATE_START_PASS")
    private Date passwordStartDate;

    @Column(name = "DATE_END_PASS")
    private Date passwordEndDate;

    @Column(name = "BLOCK_ACCESS")
    private String blockAccess;

    @Column(name = "LANGUAGE_CODE")
    private String languageCode;

    @Column(name = "LAST_4_PWD")
    private String lastFourPasswords;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "MOBILE_NUMBER")
    private String mobileNumber;

    @Column(name = "FORGOTPWD_REQUEST")
    private String forgotPasswordRequest;

    @Column(name = "SECRET_KEY")
    private String secretKey;

}