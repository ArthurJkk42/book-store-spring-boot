package com.bookstore.Book_Store.mappers.manualmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateCartItemsDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.CartItemsResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateCartItemsDto;
import com.bookstore.Book_Store.models.entities.Book;
import com.bookstore.Book_Store.models.entities.Cart;
import com.bookstore.Book_Store.models.entities.CartItems;
import org.springframework.stereotype.Component;

@Component
public class CartItemsMapper {

    public CartItems toEntity(CreateCartItemsDto dto, Cart cart, Book book) {
        CartItems item = new CartItems();
        item.setCart(cart);
        item.setBook(book);
        item.setQuantity(dto.getQuantity());
        return item;
    }

    public void updateEntity(UpdateCartItemsDto dto, CartItems item, Book book) {
        if (book != null) item.setBook(book);
        if (dto.getQuantity() != null) item.setQuantity(dto.getQuantity());
    }

    public CartItemsResponseDto toResponse(CartItems item) {
        CartItemsResponseDto dto = new CartItemsResponseDto();
        dto.setId(item.getId());
        dto.setBookTitle(item.getBook().getTitle());
        dto.setQuantity(item.getQuantity());
        return dto;
    }
}

