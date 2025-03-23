package com.bookstore.Book_Store.models.dtos.updatedtos;

import com.bookstore.Book_Store.models.enums.ReviewRating;
import lombok.Data;

@Data
public class UpdateReviewDto {
    private Long userId;
    private Long bookId;
    private ReviewRating rating;
    private String comment;
}

