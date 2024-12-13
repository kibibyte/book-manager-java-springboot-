package com.myapp.usecase.category.book.add;

import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
class AddBookToCategoryRequest {

  @NotNull
  Long bookId;
}
