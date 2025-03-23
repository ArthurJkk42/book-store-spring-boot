package com.bookstore.Book_Store.models.dtos.createdtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateStoreDto {
    @NotBlank
    private String name;

    private String location;
    private String contactEmail;
    private String contactPhone;
}
