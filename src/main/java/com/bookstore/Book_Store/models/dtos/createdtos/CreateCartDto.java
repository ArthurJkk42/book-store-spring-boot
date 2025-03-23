package com.bookstore.Book_Store.models.dtos.createdtos;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateCartDto {
    @NotNull
    private Long userId;
}

