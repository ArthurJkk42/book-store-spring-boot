package com.bookstore.Book_Store.services.implementations;

import com.bookstore.Book_Store.exceptions.NotFoundException;
import com.bookstore.Book_Store.mappers.mapstructmappers.BookStoreMapStructMapper;
import com.bookstore.Book_Store.models.dtos.createdtos.CreateBookStoreDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.BookStoreResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateBookStoreDto;
import com.bookstore.Book_Store.models.entities.Book;
import com.bookstore.Book_Store.models.entities.BookStore;
import com.bookstore.Book_Store.models.entities.Store;
import com.bookstore.Book_Store.repository.BookRepository;
import com.bookstore.Book_Store.repository.BookStoreRepository;
import com.bookstore.Book_Store.repository.StoreRepository;
import com.bookstore.Book_Store.services.interfaces.BookStoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookStoreServiceImpl implements BookStoreService {

    private final BookStoreRepository bookStoreRepository;
    private final BookRepository bookRepository;
    private final StoreRepository storeRepository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final BookStoreMapStructMapper bookStoreMapper;

    @Override
    public BookStoreResponseDto addBookToStore(CreateBookStoreDto dto) {
        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new NotFoundException("Book not found with ID: " + dto.getBookId()));

        Store store = storeRepository.findById(dto.getStoreId())
                .orElseThrow(() -> new NotFoundException("Store not found with ID: " + dto.getStoreId()));

        BookStore entity = bookStoreMapper.toEntity(dto);
        entity.setBook(book);
        entity.setStore(store);

        return bookStoreMapper.toResponse(bookStoreRepository.save(entity));
    }

    @Override
    public BookStoreResponseDto updateStock(Long id, UpdateBookStoreDto dto) {
        BookStore bookStore = bookStoreRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("BookStore entry not found with ID: " + id));

        bookStoreMapper.updateEntity(dto, bookStore);
        return bookStoreMapper.toResponse(bookStoreRepository.save(bookStore));
    }

    @Override
    public List<BookStoreResponseDto> getStockByBookId(Long bookId) {
        List<BookStore> bookStores = bookStoreRepository.findByBookId(bookId);
        return bookStores.stream()
                .map(bookStoreMapper::toResponse)
                .collect(Collectors.toList());
    }
}
