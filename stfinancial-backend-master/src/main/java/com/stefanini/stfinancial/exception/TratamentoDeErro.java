package com.stefanini.stfinancial.exception;

import org.modelmapper.spi.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class TratamentoDeErro {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErroDTO> tratarErro404(EntityNotFoundException ex) {
        String mensagem = "O valor passado não foi encontrado no banco de dados. " + ex.getMessage();
        ErroDTO erroDTO = new ErroDTO(HttpStatus.NOT_FOUND, mensagem);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erroDTO);
    }


    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> tratarErro400(MethodArgumentNotValidException ex) {
        Map<String, String> erros = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach((error) -> {
            String nomeCampo = error.getField();
            String mensagemErro = error.getDefaultMessage();
            erros.put(nomeCampo, mensagemErro);
        });
        return ResponseEntity.badRequest().body(erros);
    }

}
