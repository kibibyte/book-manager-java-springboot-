package com.myapp.usecase.book.delete;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
class DeleteBookController {

  private final DeleteBookService deleteBookService;

  @DeleteMapping("/books/{bookId}")
  @ResponseStatus(OK)
  void deleteBook(@PathVariable Long bookId) {
    deleteBookService.delete(bookId);
  }
}
