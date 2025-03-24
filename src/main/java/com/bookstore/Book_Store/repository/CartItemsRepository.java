package com.bookstore.Book_Store.repository;

import com.bookstore.Book_Store.models.entities.CartItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemsRepository extends JpaRepository<CartItems, Long> {
    List<CartItems> findByCartId(Long cartId);
}

