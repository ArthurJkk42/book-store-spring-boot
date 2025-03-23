package com.bookstore.Book_Store.models.dtos.responsedtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderItemsResponseDto {
    private Long id;
    private String bookTitle;
    private int quantity;
    private BigDecimal price;
}

