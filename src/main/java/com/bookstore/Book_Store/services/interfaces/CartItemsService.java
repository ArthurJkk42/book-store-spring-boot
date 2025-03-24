package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateCartItemsDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.CartItemsResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateCartItemsDto;

import java.util.List;

public interface CartItemsService {
    CartItemsResponseDto addItem(CreateCartItemsDto dto);
    CartItemsResponseDto updateItem(Long id, UpdateCartItemsDto dto);
    void removeItem(Long id);
    List<CartItemsResponseDto> getItemsByCartId(Long cartId);
}

