package com.bookstore.Book_Store.models.dtos.createdtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateOrderItemsDto {
    @NotNull
    private Long orderId;

    @NotNull
    private Long bookId;

    @Min(1)
    private int quantity;

    @NotNull
    private BigDecimal price;
}

