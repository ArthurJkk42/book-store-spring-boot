package com.bookstore.Book_Store.mappers.manualmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateWishlistDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.WishlistResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateWishlistDto;
import com.bookstore.Book_Store.models.entities.Users;
import com.bookstore.Book_Store.models.entities.Wishlist;
import org.springframework.stereotype.Component;

@Component
public class WishlistMapper {

    public Wishlist toEntity(CreateWishlistDto dto, Users user) {
        Wishlist wishlist = new Wishlist();
        wishlist.setUser(user);
        return wishlist;
    }

    public void updateEntity(UpdateWishlistDto dto, Wishlist wishlist, Users user) {
        if (user != null) wishlist.setUser(user);
    }

    public WishlistResponseDto toResponse(Wishlist wishlist) {
        WishlistResponseDto dto = new WishlistResponseDto();
        dto.setId(wishlist.getId());
        dto.setUsername(wishlist.getUser().getUsername());
        return dto;
    }
}

