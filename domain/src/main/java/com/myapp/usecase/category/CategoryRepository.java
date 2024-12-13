package com.myapp.usecase.category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository {

  Optional<Category> find(Long categoryId);

  List<Category> findAll();
}
