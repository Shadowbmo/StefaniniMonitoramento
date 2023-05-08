package com.stefanini.stfinancial.request;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import com.stefanini.stfinancial.model.AlocacaoProfissionais;
import com.stefanini.stfinancial.model.ClasseContrato;
import com.stefanini.stfinancial.model.Faturamento;
import com.stefanini.stfinancial.model.Operacao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContratoRequest implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;
	
	private Long idContrato;
	private String codigoContratoCliente;
	private String tituloContrato;
	private Integer totalParcelas;
	private Double valorTotalContrato;
	private String receitaLiquidaContrato;
	private LocalDate dataInicioContrato;
	private Double percentualMargemBrutaVenda;
	private Double limiteCustoAtacado;
	private Operacao operacao;
	private Long idOperacao;
	private ClasseContrato classeContrato;
	private Long idClasseContrato;
	private List<AlocacaoProfissionais> alocacaoProfissionais;
	private List<Faturamento> faturamentos;
	
}
