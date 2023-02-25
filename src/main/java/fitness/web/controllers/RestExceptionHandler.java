package fitness.web.controllers;

import fitness.core.exceptions.ErrorField;
import fitness.core.exceptions.MultipleErrorResponse;
import fitness.core.exceptions.SingleErrorResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.hibernate.validator.internal.engine.ConstraintViolationImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.sql.SQLException;
import java.util.Set;

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

    @ExceptionHandler(value = {ConstraintViolationException.class})
    public ResponseEntity<Exception> exepHandle(ConstraintViolationException ex) {
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        if (violations.size() > 1) {
            MultipleErrorResponse response = new MultipleErrorResponse("err");
            violations.forEach(v -> response.add(new ErrorField(v.getMessage(), v.getPropertyPath().toString())));
            return ResponseEntity.status(400).body(response);
        }
        ConstraintViolation<?> v = violations.stream().findFirst().get();
        String message = v.getPropertyPath() + ": " + v.getMessage();
        return ResponseEntity.status(400).body(
                new SingleErrorResponse("err", message));
    }

    @ExceptionHandler(value = {SQLException.class})
    public ResponseEntity<SingleErrorResponse> repeat(SQLException e){
        int indStart = e.getMessage().lastIndexOf("Подробности:");
        String message = e.getMessage().substring(indStart+13);
        return ResponseEntity.status(400).body(new SingleErrorResponse("err",message));
    }
}
