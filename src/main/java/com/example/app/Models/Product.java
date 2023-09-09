package com.example.app.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;

    @Column(name = "PRODUCT_CATEGORY")
    private String productCategory;

    @Column(name = "PRODUCT_PRICE")
    private Double productPrice;

    @Column(name = "PRODUCT_QUANTITY")
    private Integer productQuantity;

    @Column(name = "EXPIRY_DATE")
    private Date expiryDate;

    @Column(name = "BRAND")
    private String brand;

}