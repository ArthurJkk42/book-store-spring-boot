package com.bookstore.Book_Store.models.dtos.updatedtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateOrderItemsDto {
    private Long orderId;
    private Long bookId;
    private Integer quantity;
    private BigDecimal price;
}

