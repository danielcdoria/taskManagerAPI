package com.example.taskManagerAPI.erro;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErroResponse> errorTratament(IllegalArgumentException e){
        ErroResponse erro = new ErroResponse(e.getMessage());
        return ResponseEntity.badRequest().body(erro);
    }
}
