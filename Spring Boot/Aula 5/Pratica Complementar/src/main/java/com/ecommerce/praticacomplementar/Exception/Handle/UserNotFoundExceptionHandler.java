package com.ecommerce.praticacomplementar.Exception.Handle;

import com.ecommerce.praticacomplementar.DTO.ExceptionDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class UserNotFoundExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionDTO> defaultHandler(UserNotFoundException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDTO>> defaultHandler(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<ExceptionDTO> processFieldErrors = processFieldErrors(fieldErrors);
        return new ResponseEntity<>(processFieldErrors, HttpStatus.NOT_FOUND);
    }

    private List<ExceptionDTO> processFieldErrors(List<FieldError> fieldErrors) {
        List<ExceptionDTO> listaDtos = new ArrayList<>();
        for (FieldError fieldError: fieldErrors) {
            listaDtos.add(new ExceptionDTO(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return listaDtos;
    }
}