package com.bookstore.Book_Store.mappers.mapstructmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateDiscountDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.DiscountResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateDiscountDto;
import com.bookstore.Book_Store.models.entities.Discount;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface DiscountMapStructMapper {

    Discount toEntity(CreateDiscountDto dto);

    void updateEntity(UpdateDiscountDto dto, @MappingTarget Discount discount);

    DiscountResponseDto toResponse(Discount discount);
}
