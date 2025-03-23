package com.bookstore.Book_Store.models.entities;

import com.bookstore.Book_Store.models.enums.PaymentMethod;
import com.bookstore.Book_Store.models.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tb_payment")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @Enumerated(EnumType.STRING)
    private Status status;
}

