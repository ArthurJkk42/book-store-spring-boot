package com.bookstore.Book_Store.mappers.manualmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateOrderDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.OrderResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateOrderDto;
import com.bookstore.Book_Store.models.entities.Discount;
import com.bookstore.Book_Store.models.entities.Order;
import com.bookstore.Book_Store.models.entities.Users;
import com.bookstore.Book_Store.models.enums.Status;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderMapper {

    public Order toEntity(CreateOrderDto dto, Users user, BigDecimal calculatedTotal, Discount discount) {
        Order order = new Order();
        order.setUser(user);
        order.setTotalPrice(calculatedTotal);
        order.setStatus(Status.PENDING);
        // You can optionally attach a discount or log it separately
        return order;
    }

    public void updateEntity(UpdateOrderDto dto, Order order) {
        if (dto.getTotalPrice() != null) order.setTotalPrice(dto.getTotalPrice());
        if (dto.getStatus() != null) order.setStatus(dto.getStatus());
        // user update optional, but not commonly changed
    }

    public OrderResponseDto toResponse(Order order) {
        OrderResponseDto dto = new OrderResponseDto();
        dto.setId(order.getId());
        dto.setUsername(order.getUser().getUsername());
        dto.setTotalPrice(order.getTotalPrice());
        dto.setStatus(order.getStatus());
        dto.setCreatedAt(order.getUser().getCreatedAt()); // might cause errors!!! check this one if okay!!!
        // dto.setDiscountedPrice(order.getDiscountedPrice()) // if tracked
        return dto;
    }
}

