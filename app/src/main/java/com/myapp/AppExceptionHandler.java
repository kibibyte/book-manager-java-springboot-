package com.myapp;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.myapp.exceptions.DomainException;
import com.myapp.exceptions.EntityNotFoundException;
import com.myapp.exceptions.InvalidArgumentException;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(EntityNotFoundException.class)
  @ResponseBody
  public ResponseEntity<Object> handleEntityNotFound(WebRequest req, EntityNotFoundException ex) {
    logger.warn(ex.getMessage(), ex);
    var response = ErrorResponse.of(ex);

    return handleExceptionInternal(ex, response, new HttpHeaders(), NOT_FOUND, req);
  }

  @ExceptionHandler({InvalidArgumentException.class})
  @ResponseBody
  public ResponseEntity<Object> handleInvalidArgumentOrState(WebRequest req, DomainException ex) {
    logger.warn(ex.getMessage(), ex);
    var response = ErrorResponse.of(ex);

    return handleExceptionInternal(ex, response, new HttpHeaders(), BAD_REQUEST, req);
  }

}
