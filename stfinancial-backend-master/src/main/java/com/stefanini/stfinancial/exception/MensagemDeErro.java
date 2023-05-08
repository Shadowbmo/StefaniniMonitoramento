package com.stefanini.stfinancial.exception;

public class MensagemDeErro {
        private final String nomeCampo;
        private final String valorPassado;

        public MensagemDeErro(String nomeCampo, String valorPassado) {
            super();
            this.nomeCampo = nomeCampo;
            this.valorPassado = valorPassado;
        }

        public String getNomeCampo() {
            return nomeCampo;
        }

        public String getValorPassado() {
            return valorPassado;
        }
}
