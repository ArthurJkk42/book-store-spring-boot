package com.bookstore.Book_Store.mappers.mapstructmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateCartDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.CartResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateCartDto;
import com.bookstore.Book_Store.models.entities.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CartMapStructMapper {

    Cart toEntity(CreateCartDto dto);

    void updateEntity(UpdateCartDto dto, @MappingTarget Cart cart);

    CartResponseDto toResponse(Cart cart);
}

