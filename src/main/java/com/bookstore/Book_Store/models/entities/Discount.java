package com.bookstore.Book_Store.models.entities;

import com.bookstore.Book_Store.models.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tb_discount")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Discount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String code;

    private double discountPercentage;
    private LocalDate validFrom;
    private LocalDate validUntil;

    @Enumerated(EnumType.STRING)
    private Status status;
}

