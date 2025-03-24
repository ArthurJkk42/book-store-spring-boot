package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateOrderItemsDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.OrderItemsResponseDto;

import java.util.List;

public interface OrderItemsService {
    OrderItemsResponseDto addItemsToOrder(CreateOrderItemsDto dto);
    List<OrderItemsResponseDto> getItemsByOrderId(Long orderId);
}

