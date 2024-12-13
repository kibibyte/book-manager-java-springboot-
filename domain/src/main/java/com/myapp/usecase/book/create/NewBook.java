package com.myapp.usecase.book.create;

import static com.myapp.usecase.book.BookExceptions.invalidArgument;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.isBlank;

import java.util.Optional;

import com.myapp.usecase.book.BookType;

import lombok.Value;

@Value
class NewBook {

  String name;
  String description;
  BookType type;

  public NewBook(String name, String description, BookType type) {
    if (isBlank(name)) {
      throw invalidArgument();
    }
    if (type == null) {
      throw invalidArgument();
    }

    this.name = name;
    this.description = description;
    this.type = type;
  }

  public Optional<String> getDescription() {
    return ofNullable(description);
  }
}
