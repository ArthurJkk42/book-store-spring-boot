package com.bookstore.Book_Store.models.dtos.updatedtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateAuthorDto {
    private String name;
    private String bio;
    private String nationality;
    private LocalDate birthdate;
}

