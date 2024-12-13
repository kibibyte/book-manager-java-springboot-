package com.myapp.usecase.category.create;

import lombok.Value;

import java.util.Optional;

import static com.myapp.usecase.book.BookExceptions.invalidArgument;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.isBlank;

@Value
class NewCategory {

  String name;
  String description;

  public NewCategory(String name, String description) {
    if (isBlank(name)) {
      throw invalidArgument();
    }

    this.name = name;
    this.description = description;
  }

  public Optional<String> getDescription() {
    return ofNullable(description);
  }
}
