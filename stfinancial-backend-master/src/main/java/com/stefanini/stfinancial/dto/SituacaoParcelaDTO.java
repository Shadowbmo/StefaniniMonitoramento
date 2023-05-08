package com.stefanini.stfinancial.dto;

import java.io.Serializable;
import java.util.List;

import com.stefanini.stfinancial.model.Faturamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SituacaoParcelaDTO implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;
	
	private Long idSituacaoParcela;
	private String descricaoSituacaoParcela;
	private List<Faturamento> faturamentos;
}
