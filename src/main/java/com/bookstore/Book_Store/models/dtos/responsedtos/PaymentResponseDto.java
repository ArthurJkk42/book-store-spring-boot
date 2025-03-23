package com.bookstore.Book_Store.models.dtos.responsedtos;

import com.bookstore.Book_Store.models.enums.PaymentMethod;
import com.bookstore.Book_Store.models.enums.Status;
import lombok.Data;

@Data
public class PaymentResponseDto {
    private Long id;
    private Long orderId;
    private PaymentMethod paymentMethod;
    private Status status;
}

