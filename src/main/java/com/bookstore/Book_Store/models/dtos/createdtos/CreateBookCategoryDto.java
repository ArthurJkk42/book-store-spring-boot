package com.bookstore.Book_Store.models.dtos.createdtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBookCategoryDto {
    @NotNull
    private Long bookId;

    @NotNull
    private Long categoryId;
}

