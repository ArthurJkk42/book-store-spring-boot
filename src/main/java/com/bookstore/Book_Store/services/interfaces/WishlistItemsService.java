package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateWishlistItemsDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.WishlistItemsResponseDto;

import java.util.List;

public interface WishlistItemsService {
    WishlistItemsResponseDto addItem(CreateWishlistItemsDto dto);
    void removeItem(Long id);
    List<WishlistItemsResponseDto> getItemsByWishlistId(Long wishlistId);
}

