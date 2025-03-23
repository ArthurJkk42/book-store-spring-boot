package com.bookstore.Book_Store.mappers.manualmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateWishlistItemsDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.WishlistItemsResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateWishlistItemsDto;
import com.bookstore.Book_Store.models.entities.Book;
import com.bookstore.Book_Store.models.entities.Wishlist;
import com.bookstore.Book_Store.models.entities.WishlistItems;
import org.springframework.stereotype.Component;

@Component
public class WishlistItemsMapper {

    public WishlistItems toEntity(CreateWishlistItemsDto dto, Wishlist wishlist, Book book) {
        WishlistItems item = new WishlistItems();
        item.setWishlist(wishlist);
        item.setBook(book);
        return item;
    }

    public void updateEntity(UpdateWishlistItemsDto dto, WishlistItems item, Book book) {
        if (book != null) item.setBook(book);
    }

    public WishlistItemsResponseDto toResponse(WishlistItems item) {
        WishlistItemsResponseDto dto = new WishlistItemsResponseDto();
        dto.setId(item.getId());
        dto.setBookTitle(item.getBook().getTitle());
        return dto;
    }
}
