package com.stefanini.stfinancial.exception;

import org.springframework.http.HttpStatus;

public class ErroDTO {
    private HttpStatus status;
    private String mensagem;
    private String campoNaoEncontrado;
    private String valorPassado;

    public ErroDTO(HttpStatus status, String mensagem) {
        this.status = status;
        this.mensagem = mensagem;
        this.campoNaoEncontrado = campoNaoEncontrado;
        this.valorPassado = valorPassado;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }

    public String getCampoNaoEncontrado() {
        return campoNaoEncontrado;
    }

    public String getValorPassado() {
        return valorPassado;
    }
}


