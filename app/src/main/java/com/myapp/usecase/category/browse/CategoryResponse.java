package com.myapp.usecase.category.browse;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class CategoryResponse {

  Long id;
  String name;
  String description;
}
