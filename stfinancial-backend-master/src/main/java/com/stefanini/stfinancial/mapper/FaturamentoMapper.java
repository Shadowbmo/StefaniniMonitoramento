package com.stefanini.stfinancial.mapper;

import com.stefanini.stfinancial.model.Contrato;
import com.stefanini.stfinancial.model.HorasMes;
import com.stefanini.stfinancial.model.SituacaoParcela;
import com.stefanini.stfinancial.repository.ContratoRepository;
import com.stefanini.stfinancial.repository.HorasMesRepository;
import com.stefanini.stfinancial.repository.SituacaoParcelaRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.stefanini.stfinancial.dto.FaturamentoDTO;
import com.stefanini.stfinancial.model.Faturamento;
import com.stefanini.stfinancial.request.FaturamentoRequest;

@Component
public class FaturamentoMapper {
	
	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private ContratoRepository contratoRepository;
	@Autowired
	private HorasMesRepository horasMesRepository;
	@Autowired
	private SituacaoParcelaRepository situacaoParcelaRepository;

	public Faturamento toEntity(FaturamentoRequest faturamentoRequest) {
		Contrato contrato = contratoRepository.findById(faturamentoRequest.getIdContrato()).get();
		SituacaoParcela situacaoParcela = situacaoParcelaRepository.findById(faturamentoRequest.getCodigoSituacaoParcela()).get();
		HorasMes horasMes = horasMesRepository.findByMesComp(faturamentoRequest.getIdHorasMes());
		HorasMes mesPrevisao = horasMesRepository.findByMesComp(faturamentoRequest.getIdMesPrevisao());
		faturamentoRequest.setContrato(contrato);
		faturamentoRequest.setSituacaoParcela(situacaoParcela);
		faturamentoRequest.setHorasMes(horasMes);
		faturamentoRequest.setMesPrevisao(mesPrevisao);
		if(faturamentoRequest.getIdMesEmissao() != null) {
			HorasMes mesEmissao = horasMesRepository.findByMesComp(faturamentoRequest.getIdMesEmissao());
			faturamentoRequest.setMesEmissao(mesEmissao);
		}
		return modelMapper.map(faturamentoRequest, Faturamento.class);
	}
	
	public Faturamento toDto(FaturamentoDTO faturamentoDTO) {
		return modelMapper.map(faturamentoDTO, Faturamento.class);
	}
	
}