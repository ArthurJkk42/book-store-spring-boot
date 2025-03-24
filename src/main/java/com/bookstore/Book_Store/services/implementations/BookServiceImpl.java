package com.bookstore.Book_Store.services.implementations;

import com.bookstore.Book_Store.exceptions.NotFoundException;
import com.bookstore.Book_Store.mappers.manualmappers.BookMapper;
import com.bookstore.Book_Store.models.dtos.createdtos.CreateBookDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.BookResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateBookDto;
import com.bookstore.Book_Store.models.entities.Author;
import com.bookstore.Book_Store.models.entities.Book;
import com.bookstore.Book_Store.repository.AuthorRepository;
import com.bookstore.Book_Store.repository.BookRepository;
import com.bookstore.Book_Store.services.interfaces.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private final BookRepository bookRepository;
    @Autowired
    private final AuthorRepository authorRepository;
    @Autowired
    private final BookMapper bookMapper;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookMapper = bookMapper;
    }

    @Override
    public BookResponseDto create(CreateBookDto dto) {
        Author author = authorRepository.findById(dto.getAuthorId())
                .orElseThrow(() -> new NotFoundException("Author not found"));
        Book book = bookMapper.toEntity(dto, author);
        return bookMapper.toResponse(bookRepository.save(book));
    }

    @Override
    public BookResponseDto update(Long id, UpdateBookDto dto) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found"));

        Author author = null;
        if (dto.getAuthorId() != null) {
            author = authorRepository.findById(dto.getAuthorId())
                    .orElseThrow(() -> new NotFoundException("Author not found"));
        }

        bookMapper.updateEntity(dto, book, author);
        return bookMapper.toResponse(bookRepository.save(book));
    }

    @Override
    public BookResponseDto getById(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found"));
        return bookMapper.toResponse(book);
    }

    @Override
    public void delete(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Book not found"));
        bookRepository.delete(book);
    }
}


