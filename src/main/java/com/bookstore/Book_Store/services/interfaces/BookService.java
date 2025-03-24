package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateBookDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.BookResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateBookDto;

public interface BookService {
    BookResponseDto create(CreateBookDto dto);
    BookResponseDto update(Long id, UpdateBookDto dto);
    BookResponseDto getById(Long id);
    void delete(Long id);
}

