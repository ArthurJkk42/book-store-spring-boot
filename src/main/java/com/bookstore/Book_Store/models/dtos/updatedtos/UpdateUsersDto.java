package com.bookstore.Book_Store.models.dtos.updatedtos;

import lombok.Data;

@Data
public class UpdateUsersDto {
    private String username;
    private String email;
    private String password;
}
