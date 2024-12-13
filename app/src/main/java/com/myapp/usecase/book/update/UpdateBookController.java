package com.myapp.usecase.book.update;

import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
class UpdateBookController {

  private final UpdateBookService service;

  @PutMapping("/books/{bookId}")
  @ResponseStatus(OK)
  void updateBook(@PathVariable Long bookId, @RequestBody @Valid UpdateBookRequest request) {
    service.update(bookId, new UpdatedBook(
        request.getTitle(),
        request.getDescription()
    ));
  }
}
