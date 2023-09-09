package com.example.app.Models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "conversion")
@Data
@NoArgsConstructor
@Getter
@Setter
public class Conversion {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "points_converted")
    private Integer pointsConverted;

    @Column(name = "amount_converted")
    private BigDecimal amountConverted;

    @Column(name = "converted_date")
    private LocalDate convertedDate;
    @Column(name = "converted_rate")
    private  BigDecimal convertedRate;

    // Constructors
    public Conversion(Long userId, Integer pointsConverted, BigDecimal amountConverted, LocalDate convertedDate) {
        this.userId = userId;
        this.pointsConverted = pointsConverted;
        this.amountConverted = amountConverted;
        this.convertedDate = convertedDate;
    }
}