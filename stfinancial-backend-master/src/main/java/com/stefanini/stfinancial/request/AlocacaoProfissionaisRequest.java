package com.stefanini.stfinancial.request;

import java.io.Serializable;

import com.stefanini.stfinancial.model.Contrato;
import com.stefanini.stfinancial.model.HorasMes;
import com.stefanini.stfinancial.model.Profissional;

import com.stefanini.stfinancial.model.ProfissionalId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlocacaoProfissionaisRequest implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;

//	private HorasMes horasMes;
//	private Long idHorasMes;
	private Contrato contrato;
	private Long idContrato;
	private Profissional profissional;
	private ProfissionalId idProfissional;
	private Integer horasAlocacaoPrevista;
	private Integer horasAlocacaoRealizada;

}
