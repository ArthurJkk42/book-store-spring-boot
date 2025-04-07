package com.bookstore.Book_Store.services.implementations;

import com.bookstore.Book_Store.exceptions.NotFoundException;
import com.bookstore.Book_Store.mappers.mapstructmappers.CategoryMapStructMapper;
import com.bookstore.Book_Store.models.dtos.createdtos.CreateCategoryDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.CategoryResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateCategoryDto;
import com.bookstore.Book_Store.models.entities.Category;
import com.bookstore.Book_Store.repository.CategoryRepository;
import com.bookstore.Book_Store.services.interfaces.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    private final CategoryMapStructMapper categoryMapper;

    @Override
    public CategoryResponseDto create(CreateCategoryDto dto) {
        Category category = categoryMapper.toEntity(dto);
        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponseDto update(Long id, UpdateCategoryDto dto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found with ID: " + id));

        categoryMapper.updateEntity(dto, category);
        return categoryMapper.toResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponseDto getById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found with ID: " + id));
        return categoryMapper.toResponse(category);
    }

    @Override
    public void delete(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Category not found with ID: " + id));
        categoryRepository.delete(category);
    }
}

