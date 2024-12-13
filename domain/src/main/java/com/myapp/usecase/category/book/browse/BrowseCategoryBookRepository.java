package com.myapp.usecase.category.book.browse;

import java.util.List;

import com.myapp.usecase.Book;

interface BrowseCategoryBookRepository {

  List<Book> findAll(Long categoryId);
}
