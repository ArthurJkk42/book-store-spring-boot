package com.bookstore.Book_Store.mappers.manualmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateCartDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.CartResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateCartDto;
import com.bookstore.Book_Store.models.entities.Cart;
import com.bookstore.Book_Store.models.entities.Users;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    public Cart toEntity(CreateCartDto dto, Users user) {
        Cart cart = new Cart();
        cart.setUser(user);
        return cart;
    }

    public void updateEntity(UpdateCartDto dto, Cart cart, Users user) {
        if (user != null) cart.setUser(user);
    }

    public CartResponseDto toResponse(Cart cart) {
        CartResponseDto dto = new CartResponseDto();
        dto.setId(cart.getId());
        dto.setUsername(cart.getUser().getUsername());
        return dto;
    }
}

