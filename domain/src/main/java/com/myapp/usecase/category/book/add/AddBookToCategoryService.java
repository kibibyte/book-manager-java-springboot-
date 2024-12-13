package com.myapp.usecase.category.book.add;

import com.myapp.DomainComponent;
import com.myapp.usecase.BookRepository;
import com.myapp.usecase.book.BookExceptions;
import com.myapp.usecase.category.CategoryExceptions;
import com.myapp.usecase.category.CategoryRepository;

import lombok.AllArgsConstructor;

@DomainComponent
@AllArgsConstructor
public class AddBookToCategoryService {

  private final BookRepository bookRepository;
  private final CategoryRepository categoryRepository;
  private final AddBookToCategoryRepository addBookToCategoryRepository;

  void add(Long categoryId, Long bookId) {
    categoryRepository.find(categoryId)
        .orElseThrow(CategoryExceptions::categoryNotFound);

    bookRepository.find(bookId)
        .orElseThrow(BookExceptions::bookNotFound);

    addBookToCategoryRepository.add(categoryId, bookId);
  }
}
