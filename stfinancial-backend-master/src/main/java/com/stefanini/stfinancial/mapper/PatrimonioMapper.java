package com.stefanini.stfinancial.mapper;

import com.stefanini.stfinancial.dto.PatrimonioDTO;
import com.stefanini.stfinancial.model.*;
import com.stefanini.stfinancial.request.ClienteRequest;
import com.stefanini.stfinancial.request.PatrimonioRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PatrimonioMapper {

    @Autowired
    private ModelMapper modelMapper;




    public Patrimonio toEntity(PatrimonioRequest patrimonioRequest) {
        return modelMapper.map(patrimonioRequest, Patrimonio.class);
    }

    public Patrimonio toDto(PatrimonioDTO patrimonioDTO) {
        return modelMapper.map(patrimonioDTO, Patrimonio.class);
    }

}
