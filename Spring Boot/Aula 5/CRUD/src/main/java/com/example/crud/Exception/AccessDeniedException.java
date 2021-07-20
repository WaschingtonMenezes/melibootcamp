package com.example.crud.Exception;

public class AccessDeniedException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public AccessDeniedException(String mensagem) {
        super(mensagem);
    }
    public AccessDeniedException(Exception e) {
        super(e);
    }
}
