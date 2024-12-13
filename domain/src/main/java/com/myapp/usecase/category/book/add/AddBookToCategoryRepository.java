package com.myapp.usecase.category.book.add;

interface AddBookToCategoryRepository {

  void add(Long categoryId, Long bookId);
}

