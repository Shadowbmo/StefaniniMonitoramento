package com.stefanini.stfinancial.request;

import java.io.Serializable;
import java.util.List;

import com.stefanini.stfinancial.model.Faturamento;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SituacaoParcelaRequest implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;

	private Long codigoSituacaoParcela;
//	private Long idSituacaoParcela;
	private String descricaoSituacaoParcela;
	private List<Faturamento> faturamentos;
}
