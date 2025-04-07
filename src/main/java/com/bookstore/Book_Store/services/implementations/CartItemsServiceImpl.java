package com.bookstore.Book_Store.services.implementations;

import com.bookstore.Book_Store.exceptions.NotFoundException;
import com.bookstore.Book_Store.mappers.manualmappers.CartItemsMapper;
import com.bookstore.Book_Store.models.dtos.createdtos.CreateCartItemsDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.CartItemsResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateCartItemsDto;
import com.bookstore.Book_Store.models.entities.Book;
import com.bookstore.Book_Store.models.entities.Cart;
import com.bookstore.Book_Store.models.entities.CartItems;
import com.bookstore.Book_Store.repository.BookRepository;
import com.bookstore.Book_Store.repository.CartItemsRepository;
import com.bookstore.Book_Store.repository.CartRepository;
import com.bookstore.Book_Store.services.interfaces.CartItemsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CartItemsServiceImpl implements CartItemsService {

    private final CartItemsRepository cartItemsRepository;
    private final CartRepository cartRepository;
    private final BookRepository bookRepository;
    private final CartItemsMapper cartItemsMapper;

    @Override
    public CartItemsResponseDto addItem(CreateCartItemsDto dto) {
        Cart cart = cartRepository.findById(dto.getCartId())
                .orElseThrow(() -> new NotFoundException("Cart not found with ID: " + dto.getCartId()));

        Book book = bookRepository.findById(dto.getBookId())
                .orElseThrow(() -> new NotFoundException("Book not found with ID: " + dto.getBookId()));

        CartItems item = cartItemsMapper.toEntity(dto, cart, book);
        return cartItemsMapper.toResponse(cartItemsRepository.save(item));
    }

    @Override
    public CartItemsResponseDto updateItem(Long id, UpdateCartItemsDto dto) {
        CartItems item = cartItemsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cart item not found with ID: " + id));

        Book book = null;
        if (dto.getBookId() != null) {
            book = bookRepository.findById(dto.getBookId())
                    .orElseThrow(() -> new NotFoundException("Book not found with ID: " + dto.getBookId()));
        }

        cartItemsMapper.updateEntity(dto, item, book);
        return cartItemsMapper.toResponse(cartItemsRepository.save(item));
    }

    @Override
    public void removeItem(Long id) {
        CartItems item = cartItemsRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cart item not found with ID: " + id));
        cartItemsRepository.delete(item);
    }

    @Override
    public List<CartItemsResponseDto> getItemsByCartId(Long cartId) {
        List<CartItems> items = cartItemsRepository.findByCartId(cartId);
        return items.stream()
                .map(cartItemsMapper::toResponse)
                .collect(Collectors.toList());
    }
}
