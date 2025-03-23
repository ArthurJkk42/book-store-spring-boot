package com.bookstore.Book_Store.models.dtos.createdtos;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreateBookDto {
    @NotBlank
    private String title;

    @NotNull
    private Long authorId;

    private String description;

    @NotNull
    private BigDecimal price;

    private int stock;
}

