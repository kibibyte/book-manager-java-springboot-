package com.myapp.usecase.category.book.browse;

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

import com.myapp.usecase.BookResponse;
import com.myapp.usecase.BookResponse.BookResponseBuilder;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
class BrowseCategoryBookController {

  private final BrowseCategoryBookService service;
  private final ModelMapper modelMapper;

  @GetMapping("/categories/{categoryId}/books")
  @ResponseStatus(OK)
  List<BookResponse> findAll(@PathVariable Long categoryId) {
    final var books = service.findAll(categoryId);

    return books.stream()
        .map(book -> modelMapper.map(book, BookResponseBuilder.class).build())
        .collect(toList());
  }
}
