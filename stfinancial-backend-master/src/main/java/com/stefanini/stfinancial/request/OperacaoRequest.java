package com.stefanini.stfinancial.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.stefanini.stfinancial.model.Celula;
import com.stefanini.stfinancial.model.Cliente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperacaoRequest implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;
	
	private Long idOperacao;
	private String nomeOperacao;
	private String descricaoOperacao;
	private Date dataInicioVigencia;
	private Date dataFimVigencia;
	private BigDecimal percentualRetencaoEmissao;
	private Integer gapFluxoCaixa;
	private Integer matriculaGo;
	private Cliente cliente;
	private Celula celula;
	private Long clienteId;
	private Long celulaId;


}
