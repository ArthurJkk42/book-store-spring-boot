package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateCartDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.CartResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateCartDto;

public interface CartService {
    CartResponseDto create(CreateCartDto dto);
    CartResponseDto update(Long id, UpdateCartDto dto);
    CartResponseDto getByUserId(Long userId);
    void delete(Long id);
}

