package com.bookstore.Book_Store.models.dtos.createdtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateAuthorDto {
    @NotBlank
    private String name;

    private String bio;
    private String nationality;

    private LocalDate birthdate;
}

