package com.bookstore.Book_Store.models.dtos.updatedtos;

import lombok.Data;

@Data
public class UpdateBookCategoryDto {
    private Long bookId;
    private Long categoryId;
}

