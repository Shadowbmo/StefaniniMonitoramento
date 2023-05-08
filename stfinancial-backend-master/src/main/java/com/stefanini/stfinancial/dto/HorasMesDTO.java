package com.stefanini.stfinancial.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.stefanini.stfinancial.model.AlocacaoProfissionais;
import com.stefanini.stfinancial.model.Faturamento;
import com.stefanini.stfinancial.model.Operacao;

import com.stefanini.stfinancial.model.Profissional;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorasMesDTO implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;

	private Long idHorasMes;
	private LocalDate mesComp;
	private Integer horasUtilMes;
//	private List<Profissional> profissionais;
//	private List<AlocacaoProfissionais> alocacaoProfissionais;
//	private List<Faturamento> faturamentos;
//	private Long idCelula;
//	private String descricao;
//	private List<Operacao> operacoes;
}
