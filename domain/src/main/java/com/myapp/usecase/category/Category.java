package com.myapp.usecase.category;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Category {

  Long id;
  String name;
  String description;

  public Optional<String> getDescription() {
    return ofNullable(description);
  }
}
