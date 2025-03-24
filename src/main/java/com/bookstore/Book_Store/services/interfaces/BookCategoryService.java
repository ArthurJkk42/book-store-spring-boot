package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateBookCategoryDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.BookCategoryResponseDto;

public interface BookCategoryService {
    BookCategoryResponseDto create(CreateBookCategoryDto dto);
    void delete(Long id);
}

