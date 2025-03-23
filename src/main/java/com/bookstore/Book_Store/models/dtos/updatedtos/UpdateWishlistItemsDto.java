package com.bookstore.Book_Store.models.dtos.updatedtos;

import lombok.Data;

@Data
public class UpdateWishlistItemsDto {
    private Long wishlistId;
    private Long bookId;
}

