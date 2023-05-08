package com.stefanini.stfinancial.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.stefanini.stfinancial.model.HorasMes;
import com.stefanini.stfinancial.model.Operacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfissionalDTO implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;
	
	private Long matricula;
	private String nomeProfissional;
	private Date dataAdmissao;
	private BigDecimal salario;
	private BigDecimal encargos;
	private BigDecimal benefComp;
	private BigDecimal benefEmp;
	private BigDecimal custoEquipamento;
	private BigDecimal custoLicencas;
	private BigDecimal custoPessoal;
	private Double custoEfetivoTotalHora;
	private Operacao operacaoPadrao;
	private HorasMes horasMes;
	
}
