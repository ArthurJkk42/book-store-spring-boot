package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateDiscountDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.DiscountResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateDiscountDto;

public interface DiscountService {
    DiscountResponseDto create(CreateDiscountDto dto);
    DiscountResponseDto update(Long id, UpdateDiscountDto dto);
    DiscountResponseDto getByCode(String code);
    void delete(Long id);
}

