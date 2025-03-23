package com.bookstore.Book_Store.mappers.mapstructmappers;

import com.bookstore.Book_Store.models.dtos.createdtos.CreateStoreDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.StoreResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateStoreDto;
import com.bookstore.Book_Store.models.entities.Store;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface StoreMapStructMapper {

    Store toEntity(CreateStoreDto dto);

    void updateEntity(UpdateStoreDto dto, @MappingTarget Store store);

    StoreResponseDto toResponse(Store store);
}

