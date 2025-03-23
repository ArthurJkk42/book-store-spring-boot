package com.bookstore.Book_Store.models.dtos.createdtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBookStoreDto {
    @NotNull
    private Long bookId;

    @NotNull
    private Long storeId;

    private int stock;
}

