package com.crud.pedidos.Exception.Handle;

import com.crud.pedidos.DTO.ExceptionDTO;
import com.crud.pedidos.Exception.AccessDeniedException;
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
public class AccessDeniedExceptionHandler {
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ExceptionDTO> defaultHandler(AccessDeniedException e){
        return new ResponseEntity<>(new ExceptionDTO(e.getMessage()), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionDTO>> defaultHandler(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        List<FieldError> fieldErrors = result.getFieldErrors();
        List<ExceptionDTO> processFieldErrors = processFieldErrors(fieldErrors);
        return new ResponseEntity<>(processFieldErrors, HttpStatus.UNAUTHORIZED);
    }

    private List<ExceptionDTO> processFieldErrors(List<FieldError> fieldErrors) {
        List<ExceptionDTO> listaDtos = new ArrayList<>();
        for (FieldError fieldError: fieldErrors) {
            listaDtos.add(new ExceptionDTO(fieldError.getField(), fieldError.getDefaultMessage()));
        }
        return listaDtos;
    }
}
