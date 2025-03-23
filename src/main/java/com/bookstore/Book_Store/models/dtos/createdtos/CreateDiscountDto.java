package com.bookstore.Book_Store.models.dtos.createdtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateDiscountDto {
    @NotBlank
    private String code;

    @DecimalMin("0.0")
    @DecimalMax("100.0")
    private Double discountPercentage;

    private LocalDate validFrom;
    private LocalDate validUntil;
}

