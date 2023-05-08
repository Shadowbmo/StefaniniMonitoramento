package com.stefanini.stfinancial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stefanini.stfinancial.mapper.ClasseContratoMapper;
import com.stefanini.stfinancial.model.ClasseContrato;
import com.stefanini.stfinancial.request.ClasseContratoRequest;
import com.stefanini.stfinancial.service.ClasseContratoService;

@RestController
@RequestMapping("/stfinancial/classeContrato")
public class ClasseContratoController {
	
	@Autowired
	private ClasseContratoService service;
	
	@Autowired
	private ClasseContratoMapper mapper;


    
    @GetMapping("/buscar/{id}")
    public ClasseContrato buscarPorId(@PathVariable Long id) {
    	return service.findByIdClasseContrato(id);
    }
    
    @RequestMapping(path = "/salvarClasseContrato" , method = RequestMethod.POST)
    public ResponseEntity<?> salvarSituacaoParcela(@RequestBody ClasseContratoRequest request) {
    	ClasseContrato classe = mapper.toEntity(request);
    	return ResponseEntity.ok(service.inserirClasseContrato(classe));
    }
    @RequestMapping(path = "/alterarClasseContrato" , method = RequestMethod.PUT)
    public ResponseEntity<?> alterarSituacaoParcela(@RequestBody ClasseContratoRequest request) {
    	ClasseContrato classe = mapper.toEntity(request);
    	return ResponseEntity.ok(service.alterarClasseContrato(classe));
    }
    @RequestMapping(path = "/deletarClasseContrato/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarClasseContrato(@PathVariable Long id) {
//    	ClasseContrato classe = mapper.toEntity(re);
    	return ResponseEntity.ok(service.deletarClasseContrato(id));
    }
    @RequestMapping(path = "/listarClasseContratos" , method = RequestMethod.GET)
    public ResponseEntity<?> listar() {
    	return ResponseEntity.ok(service.listarClasseContratos());
    }
}
