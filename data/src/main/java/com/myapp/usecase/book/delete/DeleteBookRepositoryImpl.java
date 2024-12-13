package com.myapp.usecase.book.delete;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
class DeleteBookRepositoryImpl implements DeleteBookRepository {

  private EntityManager entityManager;

  @Transactional
  public void delete(Long bookId) {
    entityManager.createQuery("DELETE FROM BookEntity WHERE id = :bookId")
        .setParameter("bookId", bookId)
        .executeUpdate();
  }
}
