package com.bookstore.Book_Store.models.entities;

import com.bookstore.Book_Store.models.enums.ReviewRating;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_review")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @Enumerated(EnumType.STRING)
    private ReviewRating rating;

    private String comment;
}

