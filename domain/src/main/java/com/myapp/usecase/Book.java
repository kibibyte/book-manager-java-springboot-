package com.myapp.usecase;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import com.myapp.usecase.book.BookType;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class Book {

  Long id;
  String title;
  String description;
  BookType type;

  public Optional<String> getDescription() {
    return ofNullable(description);
  }
}
