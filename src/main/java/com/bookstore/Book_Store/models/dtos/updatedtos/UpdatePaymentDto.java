package com.bookstore.Book_Store.models.dtos.updatedtos;

import com.bookstore.Book_Store.models.enums.PaymentMethod;
import com.bookstore.Book_Store.models.enums.Status;
import lombok.Data;

@Data
public class UpdatePaymentDto {
    private Long orderId;
    private PaymentMethod paymentMethod;
    private Status status;
}
