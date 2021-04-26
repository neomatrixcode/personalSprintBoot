package com.example.personal;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
class PersonalNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(PersonalNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String perosonalNotFoundHandler(PersonalNotFoundException ex) {
    return ex.getMessage();
  }
}