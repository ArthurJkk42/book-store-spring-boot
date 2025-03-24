package com.bookstore.Book_Store.repository;

import com.bookstore.Book_Store.models.entities.BookStore;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookStoreRepository extends JpaRepository<BookStore, Long> {
    List<BookStore> findByBookId(Long bookId);
    List<BookStore> findByStoreId(Long storeId);
}

