package com.bookstore.Book_Store.services.implementations;

import com.bookstore.Book_Store.mappers.mapstructmappers.AuthorMapStructMapper;
import com.bookstore.Book_Store.models.dtos.createdtos.CreateAuthorDto;
import com.bookstore.Book_Store.models.dtos.responsedtos.AuthorResponseDto;
import com.bookstore.Book_Store.models.dtos.updatedtos.UpdateAuthorDto;
import com.bookstore.Book_Store.models.entities.Author;
import com.bookstore.Book_Store.repository.AuthorRepository;
import com.bookstore.Book_Store.services.interfaces.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    @Qualifier("authorMapStructMapper")
    private final AuthorMapStructMapper authorMapper;

    @Override
    public AuthorResponseDto create(CreateAuthorDto dto) {
        Author author = authorMapper.toEntity(dto);
        Author saved = authorRepository.save(author);
        return authorMapper.toResponse(saved);
    }

    @Override
    public AuthorResponseDto update(Long id, UpdateAuthorDto dto) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Author with ID " + id + " not found"));

        authorMapper.updateEntity(dto, author);
        Author updated = authorRepository.save(author);
        return authorMapper.toResponse(updated);
    }

    @Override
    public AuthorResponseDto getById(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Author with ID " + id + " not found"));

        return authorMapper.toResponse(author);
    }

    @Override
    public void delete(Long id) {
        Author author = authorRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Author with ID " + id + " not found"));

        authorRepository.delete(author);
    }
}

