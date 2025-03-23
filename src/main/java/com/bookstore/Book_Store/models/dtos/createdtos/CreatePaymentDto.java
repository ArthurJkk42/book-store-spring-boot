package com.bookstore.Book_Store.models.dtos.createdtos;

import com.bookstore.Book_Store.models.enums.PaymentMethod;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreatePaymentDto {
    @NotNull
    private Long orderId;

    @NotNull
    private PaymentMethod paymentMethod;
}

