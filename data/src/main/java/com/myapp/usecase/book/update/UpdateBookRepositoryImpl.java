package com.myapp.usecase.book.update;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.BookEntity;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
class UpdateBookRepositoryImpl implements UpdateBookRepository {

  private EntityManager entityManager;

  @Transactional
  public void update(Long bookId, UpdatedBook updatedBook) {
    findBook(bookId).ifPresent(bookEntity -> {
      bookEntity.setTitle(updatedBook.getName());
      updatedBook.getDescription()
          .ifPresent(bookEntity::setDescription);

      entityManager.merge(bookEntity);
    });
  }

  private Optional<BookEntity> findBook(Long bookId) {
    return ofNullable(entityManager.find(BookEntity.class, bookId));
  }
}
