package com.bookstore.Book_Store.models.dtos.responsedtos;

import lombok.Data;

@Data
public class BookStoreResponseDto {
    private Long id;
    private String bookTitle;
    private String storeName;
    private int stock;
}

