package com.bookstore.Book_Store.services.implementations;

import com.bookstore.Book_Store.exceptions.NotFoundException;
import com.bookstore.Book_Store.mappers.manualmappers.OrderItemsMapper;
import com.bookstore.Book_Store.models.dtos.createdtos.CreateOrderItemsDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.OrderItemsResponseDto;
import com.bookstore.Book_Store.models.entities.Book;
import com.bookstore.Book_Store.models.entities.Order;
import com.bookstore.Book_Store.models.entities.OrderItems;
import com.bookstore.Book_Store.repository.BookRepository;
import com.bookstore.Book_Store.repository.OrderItemsRepository;
import com.bookstore.Book_Store.repository.OrderRepository;
import com.bookstore.Book_Store.services.interfaces.OrderItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderItemsServiceImpl implements OrderItemsService {

    private final OrderItemsRepository orderItemsRepository;
    private final OrderRepository orderRepository;
    private final BookRepository bookRepository;
    private final OrderItemsMapper orderItemsMapper;

    @Override
    public OrderItemsResponseDto addItemsToOrder(CreateOrderItemsDto dto) {
        Order order = orderRepository.findById(dto.getOrderId())
                .orElseThrow(() -> new NotFoundException("Order not found with ID: " + dto.getOrderId()));

        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new NotFoundException("Book not found with ID: " + dto.getBookId()));

        OrderItems orderItem = orderItemsMapper.toEntity(dto, order, book);
        OrderItems saved = orderItemsRepository.save(orderItem);
        return orderItemsMapper.toResponse(saved);
    }

    @Override
    public List<OrderItemsResponseDto> getItemsByOrderId(Long orderId) {
        List<OrderItems> items = orderItemsRepository.findByOrderId(orderId);
        return items.stream()
                .map(orderItemsMapper::toResponse)
                .collect(Collectors.toList());
    }
}

