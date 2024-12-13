package com.myapp.usecase.category.book.add;

import static java.util.Optional.ofNullable;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.BookEntity;
import com.myapp.usecase.CategoryEntity;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
class AddBookToCategoryRepositoryImpl implements AddBookToCategoryRepository {

  private EntityManager entityManager;

  @Override
  @Transactional
  public void add(Long categoryId, Long bookId) {
    findGroup(categoryId)
        .ifPresent(groupEntity -> findBook(bookId)
            .ifPresent(bookEntity -> groupEntity.getBooks().add(bookEntity)));
  }

  public Optional<CategoryEntity> findGroup(Long categoryId) {
    return ofNullable(entityManager.find(CategoryEntity.class, categoryId));
  }

  public Optional<BookEntity> findBook(Long bookId) {
    return ofNullable(entityManager.find(BookEntity.class, bookId));
  }
}
