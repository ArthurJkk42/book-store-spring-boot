package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateOrderDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.OrderResponseDto;
import com.bookstore.Book_Store.models.enums.Status;

import java.util.List;

public interface OrderService {
    OrderResponseDto create(CreateOrderDto dto);
    OrderResponseDto updateStatus(Long orderId, Status status);
    List<OrderResponseDto> getByUserId(Long userId);
    OrderResponseDto getById(Long id);
}

