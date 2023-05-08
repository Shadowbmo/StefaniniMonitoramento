package com.stefanini.stfinancial.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperacaoDTO implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;
	
	private Long idOperacao;
	private String nomeOperacao;
	private String descricaoOperacao;
	private Date dataInicioVigencia;
	private Date dataFimVigencia;
	private BigDecimal percentualRetencaoEmissao;
	private Integer fluxoCaixa;
	private Integer matriculaGO;
	
}
