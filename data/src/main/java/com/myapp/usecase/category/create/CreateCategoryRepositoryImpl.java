package com.myapp.usecase.category.create;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.myapp.usecase.CategoryEntity;
import com.myapp.usecase.CategoryMapper;
import com.myapp.usecase.category.Category;

import lombok.AllArgsConstructor;

@Repository
@AllArgsConstructor
class CreateCategoryRepositoryImpl implements CreateCategoryRepository {

  private EntityManager entityManager;

  @Transactional
  public Category create(NewCategory newCategory) {
    final var newGroupEntity = new CategoryEntity();
    newGroupEntity.setName(newCategory.getName());
    newGroupEntity.setDescription(newCategory.getDescription().orElse(null));

    entityManager.persist(newGroupEntity);

    return CategoryMapper.map(newGroupEntity);
  }
}
