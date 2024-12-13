package com.myapp.usecase.book.delete;

import com.myapp.DomainComponent;
import com.myapp.usecase.BookRepository;
import com.myapp.usecase.book.BookExceptions;

import lombok.AllArgsConstructor;

@DomainComponent
@AllArgsConstructor
public class DeleteBookService {

  private final BookRepository bookRepository;
  private final DeleteBookRepository deleteBookRepository;

  void delete(Long bookId) {
    bookRepository.find(bookId)
        .orElseThrow(BookExceptions::bookNotFound);

    deleteBookRepository.delete(bookId);
  }
}
