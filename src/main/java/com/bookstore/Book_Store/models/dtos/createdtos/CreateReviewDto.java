package com.bookstore.Book_Store.models.dtos.createdtos;

import com.bookstore.Book_Store.models.enums.ReviewRating;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateReviewDto {
    @NotNull
    private Long userId;

    @NotNull
    private Long bookId;

    @NotNull
    private ReviewRating rating;

    private String comment;
}

