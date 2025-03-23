package com.bookstore.Book_Store.models.dtos.responsedtos;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AuthorResponseDto {
    private Long id;
    private String name;
    private String bio;
    private String nationality;
    private LocalDate birthdate;
}

