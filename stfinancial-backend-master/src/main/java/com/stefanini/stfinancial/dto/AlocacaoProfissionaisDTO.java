package com.stefanini.stfinancial.dto;

import java.io.Serializable;

import com.stefanini.stfinancial.model.Contrato;
import com.stefanini.stfinancial.model.HorasMes;
import com.stefanini.stfinancial.model.Profissional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlocacaoProfissionaisDTO implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;

	private HorasMes horasMes;
	private Contrato contrato;
	private Profissional profissional;
	private Integer horasAlocacaoPrevista;
	private Integer horasAlocacaoReal;
	
}
