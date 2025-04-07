package com.bookstore.Book_Store.services.implementations;

import com.bookstore.Book_Store.exceptions.NotFoundException;
import com.bookstore.Book_Store.mappers.manualmappers.PaymentMapper;
import com.bookstore.Book_Store.models.dtos.createdtos.CreatePaymentDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.PaymentResponseDto;
import com.bookstore.Book_Store.models.entities.Order;
import com.bookstore.Book_Store.models.entities.Payment;
import com.bookstore.Book_Store.models.enums.Status;
import com.bookstore.Book_Store.repository.OrderRepository;
import com.bookstore.Book_Store.repository.PaymentRepository;
import com.bookstore.Book_Store.services.interfaces.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;
    private final OrderRepository orderRepository;
    private final PaymentMapper paymentMapper;

    @Override
    public PaymentResponseDto create(CreatePaymentDto dto) {
        Order order = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new NotFoundException("Order not found with ID: " + dto.getOrderId()));

        Payment payment = paymentMapper.toEntity(dto, order); // pass both dto and order
        return paymentMapper.toResponse(paymentRepository.save(payment));
    }


    @Override
    public PaymentResponseDto updateStatus(Long id, Status status) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Payment not found with ID: " + id));

        payment.setStatus(status);
        return paymentMapper.toResponse(paymentRepository.save(payment));
    }

    @Override
    public PaymentResponseDto getByOrderId(Long orderId) {
        Payment payment = paymentRepository.findByOrderId(orderId)
                .orElseThrow(() -> new NotFoundException("Payment not found for order ID: " + orderId));
        return paymentMapper.toResponse(payment);
    }
}

