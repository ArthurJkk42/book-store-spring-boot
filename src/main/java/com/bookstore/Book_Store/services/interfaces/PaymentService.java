package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreatePaymentDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.PaymentResponseDto;
import com.bookstore.Book_Store.models.enums.Status;

public interface PaymentService {
    PaymentResponseDto create(CreatePaymentDto dto);
    PaymentResponseDto updateStatus(Long id, Status status);
    PaymentResponseDto getByOrderId(Long orderId);
}

