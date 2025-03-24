package com.bookstore.Book_Store.repository;

import com.bookstore.Book_Store.models.entities.WishlistItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WishlistItemsRepository extends JpaRepository<WishlistItems, Long> {
    List<WishlistItems> findByWishlistId(Long wishlistId);
}

