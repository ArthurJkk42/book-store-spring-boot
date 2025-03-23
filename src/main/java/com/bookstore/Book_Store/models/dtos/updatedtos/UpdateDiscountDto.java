package com.bookstore.Book_Store.models.dtos.updatedtos;

import com.bookstore.Book_Store.models.enums.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateDiscountDto {
    private String code;
    private Double discountPercentage;
    private LocalDate validFrom;
    private LocalDate validUntil;
    private Status status;
}

