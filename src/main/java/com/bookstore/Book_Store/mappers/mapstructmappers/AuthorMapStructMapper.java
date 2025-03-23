package com.bookstore.Book_Store.mappers.mapstructmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateAuthorDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.AuthorResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateAuthorDto;
import com.bookstore.Book_Store.models.entities.Author;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface AuthorMapStructMapper {

    Author toEntity(CreateAuthorDto dto);

    void updateEntity(UpdateAuthorDto dto, @MappingTarget Author author);

    AuthorResponseDto toResponse(Author author);
}

