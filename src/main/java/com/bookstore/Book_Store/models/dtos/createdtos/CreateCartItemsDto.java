package com.bookstore.Book_Store.models.dtos.createdtos;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateCartItemsDto {
    @NotNull
    private Long cartId;

    @NotNull
    private Long bookId;

    @Min(1)
    private int quantity;
}
