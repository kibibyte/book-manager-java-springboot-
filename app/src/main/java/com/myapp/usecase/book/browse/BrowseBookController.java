package com.myapp.usecase.book.browse;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.usecase.Book;
import com.myapp.usecase.BookRepository;
import com.myapp.usecase.BookResponse;
import com.myapp.usecase.BookResponse.BookResponseBuilder;
import com.myapp.usecase.book.BookExceptions;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
class BrowseBookController {

  private final BookRepository repository;
  private final ModelMapper modelMapper;

  @GetMapping("/books")
  @ResponseStatus(OK)
  List<BookResponse> findAll() {
    final var books = repository.findAll();

    return books.stream()
        .map(this::toResponse)
        .collect(toList());
  }

  @GetMapping("/books/{bookId}")
  @ResponseStatus(OK)
  BookResponse find(@PathVariable Long bookId) {
    final var book = repository.find(bookId)
        .orElseThrow(BookExceptions::bookNotFound);

    return toResponse(book);
  }

  private BookResponse toResponse(Book book) {
    return modelMapper.map(book, BookResponseBuilder.class).build();
  }
}
