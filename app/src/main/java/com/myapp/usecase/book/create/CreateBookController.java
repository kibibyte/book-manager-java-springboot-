package com.myapp.usecase.book.create;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.usecase.BookResponse;
import com.myapp.usecase.BookResponse.BookResponseBuilder;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
class CreateBookController {

  private final CreateBookRepository repository;
  private final ModelMapper mapper;

  @PostMapping("/books")
  @ResponseStatus(CREATED)
  BookResponse createBook(@RequestBody @Valid CreateBookRequest request) {
    final var newBook = repository.create(new NewBook(
        request.getName(),
        request.getDescription(),
        request.getType()
    ));

    return mapper.map(newBook, BookResponseBuilder.class)
        .build();
  }
}
