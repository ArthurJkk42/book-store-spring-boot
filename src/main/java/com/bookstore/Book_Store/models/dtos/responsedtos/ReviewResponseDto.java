package com.bookstore.Book_Store.models.dtos.responsedtos;

import com.bookstore.Book_Store.models.enums.ReviewRating;
import lombok.Data;

@Data
public class ReviewResponseDto {
    private Long id;
    private String username;
    private String bookTitle;
    private ReviewRating rating;
    private String comment;
}

