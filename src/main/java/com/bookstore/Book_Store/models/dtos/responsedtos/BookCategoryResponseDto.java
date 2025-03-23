package com.bookstore.Book_Store.models.dtos.responsedtos;

import lombok.Data;

@Data
public class BookCategoryResponseDto {
    private Long id;
    private String bookTitle;
    private String categoryName;
}

