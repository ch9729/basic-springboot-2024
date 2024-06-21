package com.example.backboard.common;

import org.springframework.http.HttpStatus;

public @interface ReseponseStatus {

    HttpStatus value();

    String reason();

}
