package com.myapp.usecase;

import static java.util.Optional.ofNullable;
import static java.util.stream.Collectors.toList;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.category.Category;
import com.myapp.usecase.category.CategoryRepository;

import lombok.AllArgsConstructor;
import lombok.val;

@Repository
@AllArgsConstructor
class CategoryRepositoryImpl implements CategoryRepository {

  private EntityManager entityManager;

  @Override
  public Optional<Category> find(Long categoryId) {
    return ofNullable(entityManager.find(CategoryEntity.class, categoryId))
        .map(CategoryMapper::map);
  }

  public List<Category> findAll() {
    val groups = entityManager.createQuery("SELECT g FROM CategoryEntity g", CategoryEntity.class)
        .getResultList();

    return groups.stream()
        .map(CategoryMapper::map)
        .collect(toList());
  }
}

