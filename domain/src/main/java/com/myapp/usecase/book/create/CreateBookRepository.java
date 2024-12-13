package com.myapp.usecase.book.create;

import com.myapp.usecase.Book;

interface CreateBookRepository {

  Book create(NewBook newBook);
}
