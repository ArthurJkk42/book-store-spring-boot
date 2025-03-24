package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateCategoryDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.CategoryResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateCategoryDto;

public interface CategoryService {
    CategoryResponseDto create(CreateCategoryDto dto);
    CategoryResponseDto update(Long id, UpdateCategoryDto dto);
    CategoryResponseDto getById(Long id);
    void delete(Long id);
}

