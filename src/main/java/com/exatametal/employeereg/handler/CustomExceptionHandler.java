package com.exatametal.employeereg.handler;

import com.exatametal.employeereg.model.DTO.ErrorDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Set;
import java.util.stream.Collectors;

@ControllerAdvice
@Log4j2
public class CustomExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<String> handleNullPointerException(NullPointerException ex) {

        return new ResponseEntity<>("Erro na aplicação, Null" , HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Set<ErrorDTO>> handleNullPointerException(MethodArgumentNotValidException ex) {

        log.error("Exception {}, Message: {}", ex.getClass().getName(), ex.getMessage());
        Set<ErrorDTO> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> buildError(error.getCode(), error.getDefaultMessage()))
                .collect(Collectors.toSet());

        return new ResponseEntity<>(errors , HttpStatus.BAD_REQUEST);

    }

    private ErrorDTO buildError(String code, String message) {
        return new ErrorDTO(code, message);
    }
}
