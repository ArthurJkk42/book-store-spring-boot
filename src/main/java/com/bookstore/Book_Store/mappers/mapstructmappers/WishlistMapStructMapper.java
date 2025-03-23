package com.bookstore.Book_Store.mappers.mapstructmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateWishlistDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.WishlistResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateWishlistDto;
import com.bookstore.Book_Store.models.entities.Wishlist;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface WishlistMapStructMapper {

    Wishlist toEntity(CreateWishlistDto dto);

    void updateEntity(UpdateWishlistDto dto, @MappingTarget Wishlist wishlist);

    WishlistResponseDto toResponse(Wishlist wishlist);
}

