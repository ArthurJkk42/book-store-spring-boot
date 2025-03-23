package com.bookstore.Book_Store.mappers.mapstructmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateCategoryDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.CategoryResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateCategoryDto;
import com.bookstore.Book_Store.models.entities.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CategoryMapStructMapper {

    Category toEntity(CreateCategoryDto dto);

    void updateEntity(UpdateCategoryDto dto, @MappingTarget Category category);

    CategoryResponseDto toResponse(Category category);
}

