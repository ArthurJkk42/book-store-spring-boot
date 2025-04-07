package com.bookstore.Book_Store.services.implementations;

import com.bookstore.Book_Store.exceptions.NotFoundException;
import com.bookstore.Book_Store.mappers.manualmappers.CartMapper;
import com.bookstore.Book_Store.models.dtos.createdtos.CreateCartDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.CartResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateCartDto;
import com.bookstore.Book_Store.models.entities.Cart;
import com.bookstore.Book_Store.models.entities.Users;
import com.bookstore.Book_Store.repository.CartRepository;
import com.bookstore.Book_Store.repository.UsersRepository;
import com.bookstore.Book_Store.services.interfaces.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;
    private final UsersRepository usersRepository;
    private final CartMapper cartMapper;

    @Override
    public CartResponseDto create(CreateCartDto dto) {
        Users user = usersRepository.findById(dto.getUserId())
                .orElseThrow(() -> new NotFoundException("User not found with ID: " + dto.getUserId()));

        Cart cart = cartMapper.toEntity(dto, user);
        return cartMapper.toResponse(cartRepository.save(cart));
    }

    @Override
    public CartResponseDto update(Long id, UpdateCartDto dto) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cart not found with ID: " + id));

        Users user = null;
        if (dto.getUserId() != null) {
            user = usersRepository.findById(dto.getUserId())
                    .orElseThrow(() -> new NotFoundException("User not found with ID: " + dto.getUserId()));
        }

        cartMapper.updateEntity(dto, cart, user);
        return cartMapper.toResponse(cartRepository.save(cart));
    }

    @Override
    public CartResponseDto getByUserId(Long userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("Cart not found for user with ID: " + userId));
        return cartMapper.toResponse(cart);
    }

    @Override
    public void delete(Long id) {
        Cart cart = cartRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Cart not found with ID: " + id));
        cartRepository.delete(cart);
    }
}

