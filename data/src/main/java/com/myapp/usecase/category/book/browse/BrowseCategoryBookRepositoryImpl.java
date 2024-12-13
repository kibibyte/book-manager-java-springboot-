package com.myapp.usecase.category.book.browse;

import static java.util.Collections.emptyList;
import static java.util.Optional.ofNullable;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.Book;
import com.myapp.usecase.BookMapper;
import com.myapp.usecase.CategoryEntity;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
class BrowseCategoryBookRepositoryImpl implements BrowseCategoryBookRepository {

  private EntityManager entityManager;

  @Override
  public List<Book> findAll(Long categoryId) {
    return findGroup(categoryId)
        .map(CategoryEntity::getBooks)
        .map(books -> books.stream().map(BookMapper::map))
        .map(Stream::toList)
        .orElse(emptyList());
  }

  private Optional<CategoryEntity> findGroup(Long categoryId) {
    return ofNullable(entityManager.find(CategoryEntity.class, categoryId));
  }
}
