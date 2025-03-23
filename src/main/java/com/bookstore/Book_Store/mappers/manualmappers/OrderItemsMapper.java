package com.bookstore.Book_Store.mappers.manualmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateOrderItemsDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.OrderItemsResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateOrderItemsDto;
import com.bookstore.Book_Store.models.entities.Book;
import com.bookstore.Book_Store.models.entities.Order;
import com.bookstore.Book_Store.models.entities.OrderItems;
import org.springframework.stereotype.Component;

@Component
public class OrderItemsMapper {

    public OrderItems toEntity(CreateOrderItemsDto dto, Order order, Book book) {
        OrderItems item = new OrderItems();
        item.setOrder(order);
        item.setBook(book);
        item.setQuantity(dto.getQuantity());
        item.setPrice(dto.getPrice());
        return item;
    }

    public void updateEntity(UpdateOrderItemsDto dto, OrderItems item, Book book) {
        if (book != null) item.setBook(book);
        if (dto.getQuantity() != null) item.setQuantity(dto.getQuantity());
        if (dto.getPrice() != null) item.setPrice(dto.getPrice());
    }

    public OrderItemsResponseDto toResponse(OrderItems item) {
        OrderItemsResponseDto dto = new OrderItemsResponseDto();
        dto.setId(item.getId());
        dto.setBookTitle(item.getBook().getTitle());
        dto.setQuantity(item.getQuantity());
        dto.setPrice(item.getPrice());
        return dto;
    }
}

