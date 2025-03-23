package com.bookstore.Book_Store.models.dtos.updatedtos;

import com.bookstore.Book_Store.models.enums.Status;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdateOrderDto {
    private Long userId;
    private BigDecimal totalPrice;
    private Long discountId;
    private Status status;
}

