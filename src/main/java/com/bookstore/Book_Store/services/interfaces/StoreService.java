package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateStoreDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.StoreResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateStoreDto;

public interface StoreService {
    StoreResponseDto create(CreateStoreDto dto);
    StoreResponseDto update(Long id, UpdateStoreDto dto);
    StoreResponseDto getById(Long id);
    void delete(Long id);
}

