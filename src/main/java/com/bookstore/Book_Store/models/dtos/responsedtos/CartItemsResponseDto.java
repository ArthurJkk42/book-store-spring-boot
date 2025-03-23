package com.bookstore.Book_Store.models.dtos.responsedtos;

import lombok.Data;

@Data
public class CartItemsResponseDto {
    private Long id;
    private String bookTitle;
    private int quantity;
}

