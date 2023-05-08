package com.stefanini.stfinancial.mapper;

import com.stefanini.stfinancial.dto.ControleDTO;
import com.stefanini.stfinancial.dto.ProfissionalDTO;
import com.stefanini.stfinancial.model.*;
import com.stefanini.stfinancial.repository.HorasMesRepository;
import com.stefanini.stfinancial.repository.OperacaoRepository;
import com.stefanini.stfinancial.repository.PatrimonioRepository;
import com.stefanini.stfinancial.repository.ProfissionalRepository;
import com.stefanini.stfinancial.request.ControleRequest;
import com.stefanini.stfinancial.request.PatrimonioRequest;
import com.stefanini.stfinancial.request.ProfissionalRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class ControleMapper {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private PatrimonioRepository patrimonioRepository;

    @Autowired
    private ProfissionalRepository profissionalRepository;

    public Controle toEntity(ControleRequest controleRequest) {
        Controle controle = modelMapper.map(controleRequest, Controle.class);
//        ControlePK controlePK = new ControlePK();
//        controlePK.setIdControle(controleRequest.getIdControle());
//        controlePK.setIdPatrimonio(controleRequest.getIdPatrimonio());
//        controle.setControlePK(controlePK);
        return controle;
    }



    public Controle toDto(ControleDTO controleDTO) {
        return modelMapper.map(controleDTO, Controle.class);
    }

}
