package com.myapp.usecase;

import java.util.List;
import java.util.Optional;

public interface BookRepository {

  Optional<Book> find(Long bookId);

  List<Book> findAll();
}
