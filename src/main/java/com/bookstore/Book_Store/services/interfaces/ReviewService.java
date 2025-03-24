package com.bookstore.Book_Store.services.interfaces;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateReviewDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.ReviewResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateReviewDto;

import java.util.List;

public interface ReviewService {
    ReviewResponseDto create(CreateReviewDto dto);
    ReviewResponseDto update(Long id, UpdateReviewDto dto);
    List<ReviewResponseDto> getByBookId(Long bookId);
    void delete(Long id);
}

