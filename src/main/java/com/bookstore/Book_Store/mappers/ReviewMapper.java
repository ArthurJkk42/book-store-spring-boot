package com.bookstore.Book_Store.mappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateReviewDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.ReviewResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateReviewDto;
import com.bookstore.Book_Store.models.entities.Book;
import com.bookstore.Book_Store.models.entities.Review;
import com.bookstore.Book_Store.models.entities.Users;
import org.springframework.stereotype.Component;

@Component
public class ReviewMapper {

    public Review toEntity(CreateReviewDto dto, Users user, Book book) {
        Review review = new Review();
        review.setUser(user);
        review.setBook(book);
        review.setRating(dto.getRating());
        review.setComment(dto.getComment());
        return review;
    }

    public void updateEntity(UpdateReviewDto dto, Review review) {
        if (dto.getRating() != null) review.setRating(dto.getRating());
        if (dto.getComment() != null) review.setComment(dto.getComment());
    }

    public ReviewResponseDto toResponse(Review review) {
        ReviewResponseDto dto = new ReviewResponseDto();
        dto.setId(review.getId());
        dto.setUsername(review.getUser().getUsername());
        dto.setBookTitle(review.getBook().getTitle());
        dto.setRating(review.getRating());
        dto.setComment(review.getComment());
        return dto;
    }
}

