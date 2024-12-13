package com.myapp.usecase.book.update;

import javax.validation.constraints.NotEmpty;

import lombok.Value;

@Value
class UpdateBookRequest {

  @NotEmpty
  String title;
  String description;
}
