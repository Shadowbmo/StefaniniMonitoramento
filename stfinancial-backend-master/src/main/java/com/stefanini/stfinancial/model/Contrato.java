package com.stefanini.stfinancial.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Contrato implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idContrato;
	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull
	private ClasseContrato classeContrato;
	@Column
	@NotNull
	private String codigoContratoCliente;
	@Column
	@NotNull
	private String tituloContrato;
	@Column
	@NotNull
	private Integer totalParcelas;
	@Column
	@NotNull
	private Double valorTotalContrato;
	@Column
	@NotNull
	private String receitaLiquidaContrato;
	@Column
	@NotNull
	private LocalDate dataInicioContrato;
	@Column
	@NotNull
	private Double percentualMargemBrutaVenda;
	@Column
	@NotNull
	private Double limiteCustoAtacado;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idOperacao", referencedColumnName = "idOperacao")
	@NotNull
	private Operacao operacao;


	@OneToMany(fetch = FetchType.LAZY , mappedBy = "contrato")
	@JsonIgnore
	private List<AlocacaoProfissionais> alocacaoProfissionais;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "contrato")
	@JsonIgnore
	private List<Faturamento> faturamentos;
	
	public String getFrontFormatedCurrency() {
		return "R$" + String.format("%,.2f", valorTotalContrato);
	}

	public Long getIdClasseContrato(){
		return classeContrato.getCdClasseContrato();
	}
}
