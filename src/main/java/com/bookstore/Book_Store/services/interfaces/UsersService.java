package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateUsersDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.UsersResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateUsersDto;

public interface UsersService {
    UsersResponseDto create(CreateUsersDto dto);
    UsersResponseDto update(Long id, UpdateUsersDto dto);
    UsersResponseDto getById(Long id);
    void delete(Long id);
}
