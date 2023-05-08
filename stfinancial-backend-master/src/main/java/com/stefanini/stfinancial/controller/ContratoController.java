package com.stefanini.stfinancial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stefanini.stfinancial.mapper.ContratoMapper;
import com.stefanini.stfinancial.model.Contrato;
import com.stefanini.stfinancial.request.ContratoRequest;
import com.stefanini.stfinancial.service.ContratoService;

@RestController
@RequestMapping("/stfinancial/contrato")
public class ContratoController {
	
	@Autowired
	private ContratoService service;
	
	@Autowired
	private ContratoMapper mapper;


    
    @GetMapping("/buscar/{id}")
    public Contrato buscarPorId(@PathVariable Long id) {
    	return service.findByIdContrato(id);
    }
    
    @RequestMapping(path = "/salvarContrato" , method = RequestMethod.POST)
    public ResponseEntity<?> salvarContrato(@RequestBody ContratoRequest request) {
    	Contrato con = mapper.toEntity(request);
    	return ResponseEntity.ok(service.inserirContrato(con));
    }
    @RequestMapping(path = "/alterarContrato" , method = RequestMethod.PUT)
    public ResponseEntity<?> alterarContrato(@RequestBody ContratoRequest request) {
    	Contrato classe = mapper.toEntity(request);
    	return ResponseEntity.ok(service.alterarContrato(classe));
    }
    @RequestMapping(path = "/deletarContrato/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarContrato(@PathVariable Long id) {
//    	Contrato classe = mapper.toEntity(req);
    	return ResponseEntity.ok(service.deletarContrato(id));
    }
    @RequestMapping(path = "/listarContratos" , method = RequestMethod.GET)
    public ResponseEntity<?> listar() {
    	return ResponseEntity.ok(service.listarContratos());
    }
}
