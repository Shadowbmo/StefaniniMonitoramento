package com.stefanini.stfinancial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stefanini.stfinancial.mapper.OperacaoMapper;
import com.stefanini.stfinancial.model.Operacao;
import com.stefanini.stfinancial.request.OperacaoRequest;
import com.stefanini.stfinancial.service.OperacaoService;

@RestController
@RequestMapping("/stfinancial/operacao")
public class OperacaoController {
	
	@Autowired
	private OperacaoService service;
	
	@Autowired
	private OperacaoMapper mapper;


    
    @GetMapping("/buscar/{idOperacao}")
    public Operacao buscarPorId(@PathVariable Long idOperacao) {
    	return service.findByIdOperacao(idOperacao);
    }
    
    @RequestMapping(path = "/salvarOperacao" , method = RequestMethod.POST)
    public ResponseEntity<?> salvarOperacao(@RequestBody OperacaoRequest request) {
    	Operacao classe = mapper.toEntity(request);
    	return ResponseEntity.ok(service.inserirOperacao(classe));
    }
    @RequestMapping(path = "/alterarOperacao" , method = RequestMethod.PUT)
    public ResponseEntity<?> alterarOperacao(@RequestBody OperacaoRequest request) {
    	Operacao classe = mapper.toEntity(request);
    	return ResponseEntity.ok(service.alterarOperacao(classe));
    }
    @RequestMapping(path = "/deletarOperacao/{idOperacao}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarOperacao(@PathVariable Long idOperacao) {
//    	Operacao classe = mapper.toEntity(request);
    	return ResponseEntity.ok(service.deletarOperacao(idOperacao));
    }
    @RequestMapping(path = "/listarOperacoes" , method = RequestMethod.GET)
    public ResponseEntity<?> listar() {
    	return ResponseEntity.ok(service.listarOperacoes());
    }
}
