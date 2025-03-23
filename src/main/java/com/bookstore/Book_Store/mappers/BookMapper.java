package com.bookstore.Book_Store.mappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateBookDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.BookResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateBookDto;
import com.bookstore.Book_Store.models.entities.Author;
import com.bookstore.Book_Store.models.entities.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public Book toEntity(CreateBookDto dto, Author author) {
        Book book = new Book();
        book.setTitle(dto.getTitle());
        book.setAuthor(author);
        book.setDescription(dto.getDescription());
        book.setPrice(dto.getPrice());
        book.setStock(dto.getStock());
        return book;
    }

    public void updateEntity(UpdateBookDto dto, Book book, Author author) {
        if (dto.getTitle() != null) book.setTitle(dto.getTitle());
        if (dto.getDescription() != null) book.setDescription(dto.getDescription());
        if (dto.getPrice() != null) book.setPrice(dto.getPrice());
        if (dto.getStock() != null) book.setStock(dto.getStock());
        if (author != null) book.setAuthor(author);
    }

    public BookResponseDto toResponse(Book book) {
        BookResponseDto dto = new BookResponseDto();
        dto.setId(book.getId());
        dto.setTitle(book.getTitle());
        dto.setDescription(book.getDescription());
        dto.setPrice(book.getPrice());
        dto.setStock(book.getStock());
        dto.setAuthorName(book.getAuthor().getName());
        return dto;
    }
}

