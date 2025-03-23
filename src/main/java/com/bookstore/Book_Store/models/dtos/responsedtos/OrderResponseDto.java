package com.bookstore.Book_Store.models.dtos.responsedtos;

import com.bookstore.Book_Store.models.enums.Status;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class OrderResponseDto {
    private Long id;
    private String username;
    private BigDecimal totalPrice;
    private BigDecimal discountedPrice;
    private Status status;
    private LocalDateTime createdAt;
}

