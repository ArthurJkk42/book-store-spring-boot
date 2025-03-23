package com.bookstore.Book_Store.models.dtos.responsedtos;

import lombok.Data;

@Data
public class StoreResponseDto {
    private Long id;
    private String name;
    private String location;
    private String contactEmail;
    private String contactPhone;
}

