package com.bookstore.Book_Store.models.dtos.updatedtos;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateBookDto {
    private String title;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private Long authorId;
}

