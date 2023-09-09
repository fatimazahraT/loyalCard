package com.example.app.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bank")
@Data
@Getter
@Setter
public class Bank {
    @Id
    @Column(name = "bank_code", length = 5)
    private String bankCode;

    @Column(name = "wording", length = 30)
    private String wording;

    @Column(name = "currency_code", length = 3)
    private String currencyCode;

    @Column(name = "tva_rate", length = 6)
    private String tvaRate;


    @Column(name = "address", length = 120)
    private String address;

    @Column(name = "country_code", length = 3)
    private String countryCode;

    @Column(name = "zip_code", length = 20)
    private String zipCode;

    @Column(name = "city_code", length = 5)
    private String cityCode;

}
