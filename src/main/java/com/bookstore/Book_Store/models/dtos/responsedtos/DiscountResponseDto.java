package com.bookstore.Book_Store.models.dtos.responsedtos;

import com.bookstore.Book_Store.models.enums.Status;
import lombok.Data;

import java.time.LocalDate;

@Data
public class DiscountResponseDto {
    private Long id;
    private String code;
    private double discountPercentage;
    private LocalDate validFrom;
    private LocalDate validUntil;
    private Status status;
}
