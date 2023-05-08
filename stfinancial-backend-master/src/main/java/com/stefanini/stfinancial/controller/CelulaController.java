package com.stefanini.stfinancial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stefanini.stfinancial.mapper.CelulaMapper;
import com.stefanini.stfinancial.model.Celula;
import com.stefanini.stfinancial.request.CelulaRequest;
import com.stefanini.stfinancial.service.CelulaService;

@RestController
@RequestMapping("/stfinancial/celula")
public class CelulaController {
	
	@Autowired
	private CelulaService service;
	
	@Autowired
	private CelulaMapper mapper;


    
    @GetMapping("/buscar/{id}")
    public Celula buscarPorId(@PathVariable Long id) {
    	return service.buscarPorId(id);
    }
    
    @RequestMapping(path = "/salvarCelula" , method = RequestMethod.POST)
    public ResponseEntity<?> salvarCelula(@RequestBody CelulaRequest request) {
    	Celula cel = mapper.toEntity(request);
    	return ResponseEntity.ok(service.inserirCelula(cel));
    }
    @RequestMapping(path = "/alterarCelula" , method = RequestMethod.PUT)
    public ResponseEntity<?> alterarCelula(@RequestBody CelulaRequest request) {
    	Celula cel = mapper.toEntity(request);
    	return ResponseEntity.ok(service.alterarCelula(cel));
    }
    @RequestMapping(path = "/deletarCelula/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarCelula(@PathVariable Long id) {
//    	Celula cel = mapper.toEntity(request);
    	return ResponseEntity.ok(service.deletarCelula(id));
    }
    @RequestMapping(path = "/listarCelulas" , method = RequestMethod.GET)
    public ResponseEntity<?> listar() {
    	return ResponseEntity.ok(service.listarCelula());
    }
}
