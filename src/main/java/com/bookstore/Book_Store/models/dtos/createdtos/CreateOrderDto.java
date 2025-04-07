package com.bookstore.Book_Store.models.dtos.createdtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class CreateOrderDto {

    @NotNull
    private Long userId;

    @NotNull
    private BigDecimal totalPrice;
    private Long discountId; // using ID, not code
    private List<CreateOrderItemsDto> items;
}


