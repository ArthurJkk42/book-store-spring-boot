package com.bookstore.Book_Store.models.dtos.createdtos;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateUsersDto {
    @NotBlank
    private String username;

    @NotBlank
    @Email
    private String email;

    @NotBlank
    private String password;
}

