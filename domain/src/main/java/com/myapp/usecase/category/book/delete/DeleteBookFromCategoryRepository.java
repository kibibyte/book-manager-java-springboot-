package com.myapp.usecase.category.book.delete;

interface DeleteBookFromCategoryRepository {

  void delete(Long categoryId, Long bookId);
}
