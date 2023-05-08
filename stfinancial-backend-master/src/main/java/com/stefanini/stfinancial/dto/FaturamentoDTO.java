package com.stefanini.stfinancial.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import com.stefanini.stfinancial.model.Contrato;
import com.stefanini.stfinancial.model.HorasMes;
import com.stefanini.stfinancial.model.SituacaoParcela;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FaturamentoDTO implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;
	

	private Long idFaturamento;
	private LocalDate mesCompetencia;
	private BigDecimal valorPrevisao;
	private LocalDate mesPrevisao;
	private Integer numeroNotaFiscal;
	private BigDecimal valorEmitido;
	private BigDecimal receitaLiquidaParcela;
	private LocalDate mesEmissao;
	private LocalDate dataEmissao;
	private Integer codigoSituacaoParcela;
	private LocalDate dataVencimentoFatura;
	private SituacaoParcela situacaoParcela;
	private HorasMes horasMes;
	private Contrato contrato;
	
}
