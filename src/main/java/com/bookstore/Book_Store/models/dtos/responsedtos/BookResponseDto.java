package com.bookstore.Book_Store.models.dtos.responsedtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BookResponseDto {
    private Long id;
    private String title;
    private String description;
    private BigDecimal price;
    private int stock;
    private String authorName;  // pulled from Author entity
}

