package com.bookstore.Book_Store.models.dtos.createdtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateWishlistDto {
    @NotNull
    private Long userId;
}
