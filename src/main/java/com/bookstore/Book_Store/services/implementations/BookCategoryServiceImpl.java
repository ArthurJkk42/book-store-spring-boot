package com.bookstore.Book_Store.services.impl;

import com.bookstore.Book_Store.exceptions.NotFoundException;
import com.bookstore.Book_Store.mappers.manualmappers.BookCategoryMapper;
import com.bookstore.Book_Store.models.dtos.createdtos.CreateBookCategoryDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.BookCategoryResponseDto;
import com.bookstore.Book_Store.models.entities.Book;
import com.bookstore.Book_Store.models.entities.BookCategory;
import com.bookstore.Book_Store.models.entities.Category;
import com.bookstore.Book_Store.repository.BookCategoryRepository;
import com.bookstore.Book_Store.repository.BookRepository;
import com.bookstore.Book_Store.repository.CategoryRepository;
import com.bookstore.Book_Store.services.interfaces.BookCategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookCategoryServiceImpl implements BookCategoryService {

    private final BookCategoryRepository bookCategoryRepository;
    private final BookRepository bookRepository;
    private final CategoryRepository categoryRepository;
    private final BookCategoryMapper bookCategoryMapper;

    @Override
    public BookCategoryResponseDto create(CreateBookCategoryDto dto) {
        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new NotFoundException("Book not found with ID: " + dto.getBookId()));

        Category category = categoryRepository.findById(dto.getCategoryId())
                .orElseThrow(() -> new NotFoundException("Category not found with ID: " + dto.getCategoryId()));

        BookCategory bookCategory = bookCategoryMapper.toEntity(dto, book, category);
        BookCategory saved = bookCategoryRepository.save(bookCategory);
        return bookCategoryMapper.toResponse(saved);
    }

    @Override
    public void delete(Long id) {
        BookCategory bc = bookCategoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BookCategory not found with ID: " + id));
        bookCategoryRepository.delete(bc);
    }
}
