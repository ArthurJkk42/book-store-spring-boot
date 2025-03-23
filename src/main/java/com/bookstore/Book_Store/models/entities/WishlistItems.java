package com.bookstore.Book_Store.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_wishlist_items")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WishlistItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "wishlist_id", nullable = false)
    private Wishlist wishlist;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;
}

