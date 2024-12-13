package com.myapp.usecase.category.create;

import com.myapp.usecase.category.Category;

interface CreateCategoryRepository {

  Category create(NewCategory newCategory);
}
