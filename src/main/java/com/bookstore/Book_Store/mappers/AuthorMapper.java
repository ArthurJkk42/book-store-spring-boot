package com.bookstore.Book_Store.mappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateAuthorDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.AuthorResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateAuthorDto;
import com.bookstore.Book_Store.models.entities.Author;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public Author toEntity(CreateAuthorDto dto) {
        Author author = new Author();
        author.setName(dto.getName());
        author.setBio(dto.getBio());
        author.setNationality(dto.getNationality());
        author.setBirthdate(dto.getBirthdate());
        return author;
    }

    public void updateEntity(UpdateAuthorDto dto, Author author) {
        if (dto.getName() != null) author.setName(dto.getName());
        if (dto.getBio() != null) author.setBio(dto.getBio());
        if (dto.getNationality() != null) author.setNationality(dto.getNationality());
        if (dto.getBirthdate() != null) author.setBirthdate(dto.getBirthdate());
    }

    public AuthorResponseDto toResponse(Author author) {
        AuthorResponseDto dto = new AuthorResponseDto();
        dto.setId(author.getId());
        dto.setName(author.getName());
        dto.setBio(author.getBio());
        dto.setNationality(author.getNationality());
        dto.setBirthdate(author.getBirthdate());
        return dto;
    }
}

