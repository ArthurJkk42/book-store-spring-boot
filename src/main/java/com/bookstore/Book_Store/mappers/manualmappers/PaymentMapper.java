package com.bookstore.Book_Store.mappers.manualmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreatePaymentDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.PaymentResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdatePaymentDto;
import com.bookstore.Book_Store.models.entities.Order;
import com.bookstore.Book_Store.models.entities.Payment;
import com.bookstore.Book_Store.models.enums.Status;
import org.springframework.stereotype.Component;

@Component
public class PaymentMapper {

    public Payment toEntity(CreatePaymentDto dto, Order order) {
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setPaymentMethod(dto.getPaymentMethod());
        payment.setStatus(Status.PENDING); // Default
        return payment;
    }

    public void updateEntity(UpdatePaymentDto dto, Payment payment) {
        if (dto.getPaymentMethod() != null) payment.setPaymentMethod(dto.getPaymentMethod());
        if (dto.getStatus() != null) payment.setStatus(dto.getStatus());
    }

    public PaymentResponseDto toResponse(Payment payment) {
        PaymentResponseDto dto = new PaymentResponseDto();
        dto.setId(payment.getId());
        dto.setOrderId(payment.getOrder().getId());
        dto.setPaymentMethod(payment.getPaymentMethod());
        dto.setStatus(payment.getStatus());
        return dto;
    }
}

