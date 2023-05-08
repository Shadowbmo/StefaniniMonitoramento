package com.stefanini.stfinancial.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Operacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long idOperacao;
	@Column
	@NotNull
	private String nomeOperacao;
	@Column
	private String descricaoOperacao;
	@Column
	@NotNull
	private Date dataInicioVigencia;
	@Column
	@NotNull
	private Date dataFimVigencia;
	@Column
	private BigDecimal percentualRetencaoEmissao;
	@Column
	private Integer gapFluxoCaixa;
	@Column
	private Integer matriculaGo;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "operacaoPadrao")
	@JsonIgnore
	private List<Profissional> profissionais;
	
	@OneToMany(fetch = FetchType.LAZY , mappedBy = "operacao")
	@JsonIgnore
	private List<Contrato> Contratos;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCelula")
	private Celula celula;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCliente")
	private Cliente cliente;
	
	public String getFormatedDate(Date date){
		return new SimpleDateFormat("yyyy-MM").format(date);
	}
	
	public String getFrontFormatedDate(Date date) {
		return new SimpleDateFormat("MM/yyyy").format(date);
	}

	public Long getClienteId(){
		return cliente.getIdCliente();
	}

	public Long getCelulaId(){
		return celula.getIdCelula();
	}
}
