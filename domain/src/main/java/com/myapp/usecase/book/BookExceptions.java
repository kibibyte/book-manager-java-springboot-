package com.myapp.usecase.book;

import com.myapp.exceptions.EntityNotFoundException;
import com.myapp.exceptions.InvalidArgumentException;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class BookExceptions {

  public static EntityNotFoundException bookNotFound() {
    var entityNotFound = ErrorCodes.ENTITY_NOT_FOUND;

    return new EntityNotFoundException(entityNotFound.name(), entityNotFound.getMessage());
  }

  public static InvalidArgumentException invalidArgument() {
    var invalidArgument = ErrorCodes.INVALID_ARGUMENT;

    return new InvalidArgumentException(invalidArgument.name(), invalidArgument.getMessage());
  }

  @AllArgsConstructor
  @Getter
  public enum ErrorCodes {
    ENTITY_NOT_FOUND("Entity not found"),
    INVALID_ARGUMENT("Invalid argument");

    private final String message;
  }
}
