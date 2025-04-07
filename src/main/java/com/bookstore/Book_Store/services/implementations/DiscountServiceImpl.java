package com.bookstore.Book_Store.services.implementations;

import com.bookstore.Book_Store.exceptions.NotFoundException;
import com.bookstore.Book_Store.mappers.mapstructmappers.DiscountMapStructMapper;
import com.bookstore.Book_Store.models.dtos.createdtos.CreateDiscountDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.DiscountResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateDiscountDto;
import com.bookstore.Book_Store.models.entities.Discount;
import com.bookstore.Book_Store.repository.DiscountRepository;
import com.bookstore.Book_Store.services.interfaces.DiscountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DiscountServiceImpl implements DiscountService {

    private final DiscountRepository discountRepository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final DiscountMapStructMapper discountMapper;

    @Override
    public DiscountResponseDto create(CreateDiscountDto dto) {
        Discount discount = discountMapper.toEntity(dto);
        return discountMapper.toResponse(discountRepository.save(discount));
    }

    @Override
    public DiscountResponseDto update(Long id, UpdateDiscountDto dto) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Discount not found with ID: " + id));

        discountMapper.updateEntity(dto, discount);
        return discountMapper.toResponse(discountRepository.save(discount));
    }

    @Override
    public DiscountResponseDto getByCode(String code) {
        Discount discount = discountRepository.findByCode(code)
                .orElseThrow(() -> new NotFoundException("Discount not found with code: " + code));
        return discountMapper.toResponse(discount);
    }

    @Override
    public void delete(Long id) {
        Discount discount = discountRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Discount not found with ID: " + id));
        discountRepository.delete(discount);
    }
}

