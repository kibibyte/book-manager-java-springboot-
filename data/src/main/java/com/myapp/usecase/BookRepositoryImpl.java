package com.myapp.usecase;

import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;
import lombok.val;

@Repository
@AllArgsConstructor
public class BookRepositoryImpl implements BookRepository {

  private EntityManager entityManager;

  @Override
  public Optional<Book> find(Long bookId) {
    return Optional.ofNullable(entityManager.find(BookEntity.class, bookId))
        .map(BookMapper::map);
  }

  public List<Book> findAll() {
    val bookEntities = entityManager.createQuery("SELECT a FROM BookEntity a", BookEntity.class)
        .getResultList();

    return bookEntities.stream()
        .map(BookMapper::map)
        .collect(toList());
  }
}
