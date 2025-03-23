package com.bookstore.Book_Store.models.dtos.updatedtos;

import lombok.Data;

@Data
public class UpdateBookStoreDto {
    private Long bookId;
    private Long storeId;
    private Integer stock;
}

