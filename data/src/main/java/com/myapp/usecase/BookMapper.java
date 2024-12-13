package com.myapp.usecase;

final public class BookMapper {

  public static Book map(BookEntity entity) {
    return Book.builder()
        .id(entity.getId())
        .title(entity.getTitle())
        .description(entity.getDescription())
        .type(entity.getType())
        .build();
  }
}
