package com.stefanini.stfinancial.request;

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
public class FaturamentoRequest implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;
	

//	private Long idFaturamento;
//	private LocalDate mesCompetencia;
	private BigDecimal valorPrevisao;
	private Integer numeroNotaFiscal;
	private BigDecimal valorEmitido;
	private BigDecimal receitaLiquidaParcela;
	private LocalDate dataEmissaoNf;
	private LocalDate dataVencimentoFatura;
	private HorasMes horasMes;
	private String idHorasMes;
	private Contrato contrato;
	private Long idContrato;
	private SituacaoParcela situacaoParcela;
	private Long codigoSituacaoParcela;
	private HorasMes mesPrevisao;
	private String idMesPrevisao;
	private HorasMes mesEmissao;
	private String idMesEmissao;

	public LocalDate getIdHorasMes() {
		return toLocalDate(idHorasMes);
	}

	public LocalDate getIdMesPrevisao() {
		return toLocalDate(idMesPrevisao);
	}

	public LocalDate getIdMesEmissao() {
		if(idMesEmissao != null)
		return toLocalDate(idMesEmissao);
		else return null;
	}

	public LocalDate toLocalDate(String date){
		LocalDate mesComp = LocalDate.of(
				Integer.parseInt(date.substring(0, 4)),
				Integer.parseInt(date.substring(5, 7)),
				01);
		return mesComp;
	}
}
