package com.bookstore.Book_Store.services.implementations;

import com.bookstore.Book_Store.exceptions.NotFoundException;
import com.bookstore.Book_Store.mappers.manualmappers.OrderMapper;
import com.bookstore.Book_Store.models.dtos.createdtos.CreateOrderDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.OrderResponseDto;
import com.bookstore.Book_Store.models.entities.Book;
import com.bookstore.Book_Store.models.entities.Discount;
import com.bookstore.Book_Store.models.entities.Order;
import com.bookstore.Book_Store.models.entities.Users;
import com.bookstore.Book_Store.repository.BookRepository;
import com.bookstore.Book_Store.repository.DiscountRepository;
import com.bookstore.Book_Store.repository.OrderRepository;
import com.bookstore.Book_Store.repository.UsersRepository;
import com.bookstore.Book_Store.services.interfaces.OrderService;
import com.bookstore.Book_Store.models.enums.Status;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UsersRepository usersRepository;
    private final OrderMapper orderMapper;
    private final BookRepository bookRepository;
    private final DiscountRepository discountRepository;
    @Override
    public OrderResponseDto create(CreateOrderDto dto) {
        Users user = usersRepository.findById(dto.getUserId())
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + dto.getUserId()));

        Discount discount = null;
        if (dto.getDiscountId() != null) {
            discount = discountRepository.findById(dto.getDiscountId())
                    .orElseThrow(() -> new NotFoundException("Discount not found with ID: " + dto.getDiscountId()));
        }

        Order order = orderMapper.toEntity(dto, user, dto.getTotalPrice(), discount);
        return orderMapper.toResponse(orderRepository.save(order));
    }



    @Override
    public OrderResponseDto updateStatus(Long orderId, Status status) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new NotFoundException("Order not found with ID: " + orderId));

        order.setStatus(status);
        return orderMapper.toResponse(orderRepository.save(order));
    }

    @Override
    public OrderResponseDto getById(Long id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Order not found with ID: " + id));
        return orderMapper.toResponse(order);
    }

    @Override
    public List<OrderResponseDto> getByUserId(Long userId) {
        List<Order> orders = orderRepository.findByUserId(userId);
        return orders.stream()
                .map(orderMapper::toResponse)
                .collect(Collectors.toList());
    }

    private BigDecimal calculateTotal(CreateOrderDto dto) {
        return dto.getItems().stream()
                .map(item -> {
                    Book book = bookRepository.findById(item.getBookId())
                            .orElseThrow(() -> new NotFoundException("Book not found with ID: " + item.getBookId()));

                    return book.getPrice().multiply(BigDecimal.valueOf(item.getQuantity()));
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

}
