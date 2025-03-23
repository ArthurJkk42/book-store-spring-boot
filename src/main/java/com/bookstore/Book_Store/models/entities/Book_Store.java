package com.bookstore.Book_Store.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_book_store")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book_Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;

    private int stock;
}

