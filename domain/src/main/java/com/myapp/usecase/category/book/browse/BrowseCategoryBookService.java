package com.myapp.usecase.category.book.browse;

import java.util.List;

import com.myapp.DomainComponent;
import com.myapp.usecase.Book;
import com.myapp.usecase.category.CategoryExceptions;
import com.myapp.usecase.category.CategoryRepository;

import lombok.AllArgsConstructor;

@DomainComponent
@AllArgsConstructor
public class BrowseCategoryBookService {

  private final CategoryRepository categoryRepository;
  private final BrowseCategoryBookRepository browseCategoryBookRepository;

  List<Book> findAll(Long categoryId) {
    categoryRepository.find(categoryId)
        .orElseThrow(CategoryExceptions::categoryNotFound);

    return browseCategoryBookRepository.findAll(categoryId);
  }
}
