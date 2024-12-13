package com.myapp.usecase.category.book.delete;

import com.myapp.DomainComponent;
import com.myapp.usecase.BookRepository;
import com.myapp.usecase.book.BookExceptions;
import com.myapp.usecase.category.CategoryExceptions;
import com.myapp.usecase.category.CategoryRepository;

import lombok.AllArgsConstructor;

@DomainComponent
@AllArgsConstructor
public class DeleteBookFromCategoryService {

  private final BookRepository bookRepository;
  private final CategoryRepository categoryRepository;
  private final DeleteBookFromCategoryRepository deleteBookFromCategoryRepository;

  void delete(Long categoryId, Long bookId) {
    categoryRepository.find(categoryId)
        .orElseThrow(CategoryExceptions::categoryNotFound);

    bookRepository.find(bookId)
        .orElseThrow(BookExceptions::bookNotFound);

    deleteBookFromCategoryRepository.delete(categoryId, bookId);
  }
}
