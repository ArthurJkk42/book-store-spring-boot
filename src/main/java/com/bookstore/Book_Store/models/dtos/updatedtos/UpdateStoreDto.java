package com.bookstore.Book_Store.models.dtos.updatedtos;

import lombok.Data;

@Data
public class UpdateStoreDto {
    private String name;
    private String location;
    private String contactEmail;
    private String contactPhone;
}

