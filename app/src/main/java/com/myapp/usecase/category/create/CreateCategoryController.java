package com.myapp.usecase.category.create;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.usecase.category.browse.CategoryResponse;
import com.myapp.usecase.category.browse.CategoryResponse.CategoryResponseBuilder;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
class CreateCategoryController {

  private final CreateCategoryRepository repository;
  private final ModelMapper mapper;

  @PostMapping("/categories")
  @ResponseStatus(CREATED)
  CategoryResponse createCategory(@RequestBody @Valid CreateCategoryRequest request) {
    final var newlyCreatedCategory = repository.create(new NewCategory(
        request.getName(),
        request.getDescription()
    ));

    return mapper.map(newlyCreatedCategory, CategoryResponseBuilder.class).build();
  }
}
