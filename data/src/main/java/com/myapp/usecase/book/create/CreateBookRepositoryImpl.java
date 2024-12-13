package com.myapp.usecase.book.create;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.Book;
import com.myapp.usecase.BookEntity;
import com.myapp.usecase.BookMapper;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
class CreateBookRepositoryImpl implements CreateBookRepository {

  private EntityManager entityManager;

  @Transactional
  public Book create(NewBook newBook) {
    final var bookEntity = new BookEntity();
    bookEntity.setTitle(newBook.getName());
    bookEntity.setDescription(newBook.getDescription().orElse(null));
    bookEntity.setType(newBook.getType());

    entityManager.persist(bookEntity);

    return BookMapper.map(bookEntity);
  }
}
