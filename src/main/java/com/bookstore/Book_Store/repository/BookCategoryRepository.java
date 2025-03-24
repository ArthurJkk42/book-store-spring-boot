package com.bookstore.Book_Store.repository;

import com.bookstore.Book_Store.models.entities.BookCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {
    List<BookCategory> findByBookId(Long bookId);
    List<BookCategory> findByCategoryId(Long categoryId);
}
