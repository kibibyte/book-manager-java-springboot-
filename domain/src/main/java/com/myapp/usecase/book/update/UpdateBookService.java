package com.myapp.usecase.book.update;

import com.myapp.DomainComponent;
import com.myapp.usecase.BookRepository;
import com.myapp.usecase.book.BookExceptions;

import lombok.AllArgsConstructor;

@DomainComponent
@AllArgsConstructor
public class UpdateBookService {

  private final BookRepository bookRepository;
  private final UpdateBookRepository updateBookRepository;

  void update(Long bookId, UpdatedBook updatedBook) {
    bookRepository.find(bookId)
        .orElseThrow(BookExceptions::bookNotFound);

    updateBookRepository.update(bookId, updatedBook);
  }
}
