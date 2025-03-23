package com.bookstore.Book_Store.models.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_cart")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private Users user;
}

