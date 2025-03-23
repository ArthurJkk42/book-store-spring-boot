package com.bookstore.Book_Store.models.dtos.updatedtos;

import lombok.Data;

@Data
public class UpdateCartItemsDto {
    private Long cartId;
    private Long bookId;
    private Integer quantity;
}

