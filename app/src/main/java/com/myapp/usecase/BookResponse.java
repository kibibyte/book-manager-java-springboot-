package com.myapp.usecase;

import com.myapp.usecase.book.BookType;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class BookResponse {

  Long id;
  String title;
  String description;
  BookType type;
}
