package com.example.backboard.common;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "entity not found")
public class NotFoundException extends RuntimeException{
  private static final long serialVersionUID = 1L;

  public NotFoundException(String message) {
    super(message);   // RuntimeException에서 처리!
  }
  
}
