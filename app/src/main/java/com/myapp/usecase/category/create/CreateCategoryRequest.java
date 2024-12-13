package com.myapp.usecase.category.create;

import javax.validation.constraints.NotEmpty;

import lombok.Value;

@Value
class CreateCategoryRequest {

  @NotEmpty
  String name;
  String description;
}
