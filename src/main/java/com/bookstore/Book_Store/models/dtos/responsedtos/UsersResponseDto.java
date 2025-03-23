package com.bookstore.Book_Store.models.dtos.responsedtos;

import com.bookstore.Book_Store.models.enums.Role;
import lombok.Data;

@Data
public class UsersResponseDto {
    private Long id;
    private String username;
    private String email;
    private Role role;
}

