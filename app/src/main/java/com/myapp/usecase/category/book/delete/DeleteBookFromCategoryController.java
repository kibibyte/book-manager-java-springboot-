package com.myapp.usecase.category.book.delete;

import static org.springframework.http.HttpStatus.OK;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
class DeleteBookFromCategoryController {

  private final DeleteBookFromCategoryService service;

  @DeleteMapping("/categories/{categoryId}/books/{bookId}")
  @ResponseStatus(OK)
  void deleteBookFromCategory(@PathVariable Long categoryId, @PathVariable Long bookId) {
    service.delete(categoryId, bookId);
  }
}
