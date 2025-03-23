package com.bookstore.Book_Store.mappers.mapstructmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateBookCategoryDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.BookCategoryResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateBookCategoryDto;
import com.bookstore.Book_Store.models.entities.BookCategory;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface BookCategoryMapStructMapper {

    BookCategory toEntity(CreateBookCategoryDto dto);

    void updateEntity(UpdateBookCategoryDto dto, @MappingTarget BookCategory bookCategory);

    BookCategoryResponseDto toResponse(BookCategory bookCategory);
}
