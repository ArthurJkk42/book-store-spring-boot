package com.bookstore.Book_Store.models.dtos.createdtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateOrderDto {
    @NotNull
    private Long userId;

    @NotNull
    private BigDecimal totalPrice;

    private Long discountId; //Optional, but decided to keep it
}

