package com.myapp.usecase.book.update;

interface UpdateBookRepository {

  void update(Long bookId, UpdatedBook updatedBook);
}
