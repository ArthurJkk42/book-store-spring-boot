package com.bookstore.Book_Store.mappers.mapstructmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateBookStoreDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.BookStoreResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateBookStoreDto;
import com.bookstore.Book_Store.models.entities.BookStore;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookStoreMapStructMapper {

    BookStore toEntity(CreateBookStoreDto dto);

    void updateEntity(UpdateBookStoreDto dto, @MappingTarget BookStore bookStore);

    BookStoreResponseDto toResponse(BookStore bookStore);
}
