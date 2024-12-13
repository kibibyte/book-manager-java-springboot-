package com.myapp.usecase;

import com.myapp.usecase.category.Category;

final public class CategoryMapper {

  public static Category map(CategoryEntity entity) {
    return Category.builder()
        .id(entity.getId())
        .name(entity.getName())
        .description(entity.getDescription())
        .build();
  }
}
