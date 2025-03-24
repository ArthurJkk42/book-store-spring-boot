package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateAuthorDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.AuthorResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateAuthorDto;

public interface AuthorService {
    AuthorResponseDto create(CreateAuthorDto dto);
    AuthorResponseDto update(Long id, UpdateAuthorDto dto);
    AuthorResponseDto getById(Long id);
    void delete(Long id);
}
