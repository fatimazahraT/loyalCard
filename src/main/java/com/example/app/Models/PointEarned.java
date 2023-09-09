package com.example.app.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "POINT_EARNED")
@Data
@Getter
@Setter
public class PointEarned {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "EARNED_ID")
    private Long earnedId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "STORE_ID")
    private Long storeId;

    @Column(name = "PURCHASE_AMOUNT")
    private BigDecimal purchaseAmount;

    @Column(name = "POINTS_EARNED")
    private Integer pointsEarned;

    @Column(name = "EARNED_DATE")
    private Date earnedDate;
}
