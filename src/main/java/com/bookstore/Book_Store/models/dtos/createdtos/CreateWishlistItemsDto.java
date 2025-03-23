package com.bookstore.Book_Store.models.dtos.createdtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateWishlistItemsDto {
    @NotNull
    private Long wishlistId;

    @NotNull
    private Long bookId;
}

