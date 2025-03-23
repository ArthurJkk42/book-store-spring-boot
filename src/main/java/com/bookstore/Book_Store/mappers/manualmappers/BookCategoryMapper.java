package com.bookstore.Book_Store.mappers.manualmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateBookCategoryDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.BookCategoryResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateBookCategoryDto;
import com.bookstore.Book_Store.models.entities.Book;
import com.bookstore.Book_Store.models.entities.BookCategory;
import com.bookstore.Book_Store.models.entities.Category;
import org.springframework.stereotype.Component;

@Component
public class BookCategoryMapper {

    public BookCategory toEntity(CreateBookCategoryDto dto, Book book, Category category) {
        BookCategory bc = new BookCategory();
        bc.setBook(book);
        bc.setCategory(category);
        return bc;
    }

    public void updateEntity(UpdateBookCategoryDto dto, BookCategory bc, Book book, Category category) {
        if (book != null) bc.setBook(book);
        if (category != null) bc.setCategory(category);
    }

    public BookCategoryResponseDto toResponse(BookCategory bc) {
        BookCategoryResponseDto dto = new BookCategoryResponseDto();
        dto.setId(bc.getId());
        dto.setBookTitle(bc.getBook().getTitle());
        dto.setCategoryName(bc.getCategory().getName());
        return dto;
    }
}

