package com.myapp.usecase.book.create;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.myapp.usecase.book.BookType;

import lombok.Value;

@Value
class CreateBookRequest {

  @NotEmpty
  String name;
  String description;
  @NotNull
  BookType type;
}
