package com.myapp.usecase.category.book.add;

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
@RequestMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
class AddBookToCategoryController {

  private final AddBookToCategoryService service;

  @PutMapping("/categories/{categoryId}/books")
  @ResponseStatus(OK)
  void addBookToCategory(@PathVariable Long categoryId, @RequestBody @Valid AddBookToCategoryRequest request) {
    service.add(categoryId, request.getBookId());
  }
}
