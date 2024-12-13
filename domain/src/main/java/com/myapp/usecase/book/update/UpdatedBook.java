package com.myapp.usecase.book.update;

import static com.myapp.usecase.book.BookExceptions.invalidArgument;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.Optional;

import lombok.Value;

@Value
class UpdatedBook {

  String name;

  String description;

  public UpdatedBook(String name, String description) {
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
