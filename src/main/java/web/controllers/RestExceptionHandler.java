package web.controllers;

import core.exceptions.MultipleErrorResponse;
import core.exceptions.SingleErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(value = {MultipleErrorResponse.class})
    public ResponseEntity<MultipleErrorResponse> MultipleExHandle(MultipleErrorResponse e) {
        return ResponseEntity.status(400).body(e);
    }

    @ExceptionHandler(value = {SingleErrorResponse.class})
    public ResponseEntity<SingleErrorResponse> SingleExHandle(SingleErrorResponse e) {
        return ResponseEntity.status(400).body(e);
    }
}
