package com.stefanini.stfinancial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stefanini.stfinancial.mapper.SituacaoParcelaMapper;
import com.stefanini.stfinancial.model.SituacaoParcela;
import com.stefanini.stfinancial.request.SituacaoParcelaRequest;
import com.stefanini.stfinancial.service.SituacaoParcelaService;

@RestController
@RequestMapping("/stfinancial/situacaoparcela")
public class SituacaoParcelaController {
	
	@Autowired
	private SituacaoParcelaService service;
	
	@Autowired
	private SituacaoParcelaMapper mapper;


    
    @GetMapping("/buscar/{id}")
    public SituacaoParcela buscarPorId(@PathVariable Long id) {
    	return service.findByIdSituacaoParcela(id);
    }
    
    @RequestMapping(path = "/salvarSituacaoParcela" , method = RequestMethod.POST)
    public ResponseEntity<?> salvarSituacaoParcela(@RequestBody SituacaoParcelaRequest request) {
    	SituacaoParcela cel = mapper.toEntity(request);
    	return ResponseEntity.ok(service.inserirSituacaoParcela(cel));
    }
    @RequestMapping(path = "/alterarSituacaoParcela" , method = RequestMethod.PUT)
    public ResponseEntity<?> alterarSituacaoParcela(@RequestBody SituacaoParcelaRequest request) {
    	SituacaoParcela cel = mapper.toEntity(request);
    	return ResponseEntity.ok(service.alterarSituacaoParcela(cel));
    }
    @RequestMapping(path = "/deletarSituacaoParcela/{codigoSituacaoParcela}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarSituacaoParcela(@PathVariable Long codigoSituacaoParcela) {
//    	SituacaoParcela sit = mapper.toEntity(request);
    	return ResponseEntity.ok(service.deletarSituacaoParcela(codigoSituacaoParcela));
    }
    @RequestMapping(path = "/listarSituacaoParcelas" , method = RequestMethod.GET)
    public ResponseEntity<?> listar() {
    	return ResponseEntity.ok(service.listarSituacaoParcelas());
    }
}
