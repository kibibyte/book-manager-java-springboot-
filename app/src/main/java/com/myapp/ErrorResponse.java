package com.myapp;

import com.myapp.exceptions.DomainException;

import lombok.Value;

@Value
public class ErrorResponse {

  String code;
  String message;

  static ErrorResponse of(DomainException exception) {
    return new ErrorResponse(exception.getCode(), exception.getMessage());
  }

  static ErrorResponse of(String code, String message) {
    return new ErrorResponse(code, message);
  }
}
