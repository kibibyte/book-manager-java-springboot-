package com.myapp.usecase.category.browse;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.myapp.usecase.category.CategoryRepository;
import com.myapp.usecase.category.browse.CategoryResponse.CategoryResponseBuilder;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(produces = APPLICATION_JSON_VALUE)
@AllArgsConstructor
class BrowseCategoryController {

  private final CategoryRepository repository;
  private final ModelMapper modelMapper;

  @GetMapping("/categories")
  @ResponseStatus(OK)
  List<CategoryResponse> findAll() {
    final var categories = repository.findAll();

    return categories.stream()
        .map(category -> modelMapper.map(category, CategoryResponseBuilder.class).build())
        .collect(toList());
  }
}
