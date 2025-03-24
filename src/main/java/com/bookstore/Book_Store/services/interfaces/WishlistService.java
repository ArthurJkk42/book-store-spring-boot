package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateWishlistDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.WishlistResponseDto;

public interface WishlistService {
    WishlistResponseDto create(CreateWishlistDto dto);
    WishlistResponseDto getByUserId(Long userId);
    void delete(Long id);
}

