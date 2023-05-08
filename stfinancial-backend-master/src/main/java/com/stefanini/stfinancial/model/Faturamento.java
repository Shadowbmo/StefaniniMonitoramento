package com.stefanini.stfinancial.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Faturamento implements Serializable{
	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@EmbeddedId
	private FaturamentoId id;

	@MapsId("horasMes")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mesComp")
	@JsonIgnore
	private HorasMes horasMes;
	@MapsId("contrato")
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idContrato")
	@JsonIgnore
	private Contrato contrato;
	@Column
	@NotNull
	private BigDecimal valorPrevisao;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mesPrevisao", referencedColumnName = "mesComp")
	private HorasMes mesPrevisao;
	@Column
	private Integer numeroNotaFiscal;
	@Column
	private BigDecimal valorEmitido;
	@Column
	@NotNull
	private BigDecimal receitaLiquidaParcela;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mesEmissao", referencedColumnName = "mesComp")
	private HorasMes mesEmissao;
	@Column
	private LocalDate dataEmissaoNf;
	@Column
	private LocalDate dataVencimentoFatura;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigoSituacaoParcela")
	@NotNull
	private SituacaoParcela situacaoParcela;

	public LocalDate getMesComp(){
		return horasMes.getMesComp();
	}

	public String getTituloContrato(){
		return contrato.getTituloContrato();
	}
}
