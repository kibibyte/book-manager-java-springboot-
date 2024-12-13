package com.myapp.usecase.category;

import com.myapp.exceptions.EntityNotFoundException;
import com.myapp.exceptions.InvalidArgumentException;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class CategoryExceptions {

  public static EntityNotFoundException categoryNotFound() {
    var entityNotFound = ErrorCodes.GROUP_NOT_FOUND;

    return new EntityNotFoundException(entityNotFound.name(), entityNotFound.getMessage());
  }

  public static InvalidArgumentException invalidArgument() {
    var invalidArgument = ErrorCodes.INVALID_ARGUMENT;

    return new InvalidArgumentException(invalidArgument.name(), invalidArgument.getMessage());
  }

  @AllArgsConstructor
  @Getter
  public enum ErrorCodes {
    GROUP_NOT_FOUND("Category not found"),
    INVALID_ARGUMENT("Invalid argument");

    private final String message;
  }
}
