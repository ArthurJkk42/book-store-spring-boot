package com.bookstore.Book_Store.mappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateUsersDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.UsersResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateUsersDto;
import com.bookstore.Book_Store.models.entities.Users;
import com.bookstore.Book_Store.models.enums.Role;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public Users toEntity(CreateUsersDto dto, Role defaultRole, String encodedPassword) {
        Users user = new Users();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(encodedPassword);
        user.setRole(defaultRole);
        return user;
    }

    public void updateEntity(UpdateUsersDto dto, Users user, String encodedPassword) {
        if (dto.getUsername() != null) user.setUsername(dto.getUsername());
        if (dto.getEmail() != null) user.setEmail(dto.getEmail());
        if (dto.getPassword() != null) user.setPassword(encodedPassword);
    }

    public UsersResponseDto toResponse(Users user) {
        UsersResponseDto dto = new UsersResponseDto();
        dto.setId(user.getId());
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setRole(user.getRole());
        return dto;
    }
}

