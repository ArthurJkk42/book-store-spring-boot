package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateBookStoreDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.BookStoreResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateBookStoreDto;

import java.util.List;

public interface BookStoreService {
    BookStoreResponseDto addBookToStore(CreateBookStoreDto dto);
    BookStoreResponseDto updateStock(Long id, UpdateBookStoreDto dto);
    List<BookStoreResponseDto> getStockByBookId(Long bookId);
}

