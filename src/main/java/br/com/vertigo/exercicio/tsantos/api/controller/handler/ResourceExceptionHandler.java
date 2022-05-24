package br.com.vertigo.exercicio.tsantos.api.controller.handler;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.TypeMismatchException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import br.com.vertigo.exercicio.tsantos.api.service.EmployeeNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<Object> handleEmployeeNotFoundException(
            EmployeeNotFoundException exception, HttpServletRequest request) {
        ErrorModel errorModel = new ErrorModel();
        errorModel.setMessage(exception.getMessage());
        errorModel.setTimeStamp(LocalDateTime.now());
        errorModel.setStatus(String.valueOf(HttpStatus.NOT_FOUND.value()));
        errorModel.setFrom(request.getRequestURI());
        return new ResponseEntity<>(errorModel, HttpStatus.NOT_FOUND);
    }

    protected ResponseEntity<Object> handleTypeMismatch(TypeMismatchException ex,
            HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        var error = new ErrorModel();
        error.setFrom("API");
        error.setMessage("Invalid Type " + ex.getMessage());
        error.setStatus(Integer.toString(HttpStatus.BAD_REQUEST.value()));
        error.setTimeStamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);

    }

    protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
            HttpStatus status, WebRequest request) {
        var error = new ErrorModel();
        error.setFrom("API");
        error.setMessage("Internal Server Error " + ex.getMessage());
        error.setStatus(Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()));
        error.setTimeStamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

}
