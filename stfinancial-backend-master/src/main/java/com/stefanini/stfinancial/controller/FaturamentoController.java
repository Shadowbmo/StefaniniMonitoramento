package com.stefanini.stfinancial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stefanini.stfinancial.mapper.FaturamentoMapper;
import com.stefanini.stfinancial.model.Faturamento;
import com.stefanini.stfinancial.request.FaturamentoRequest;
import com.stefanini.stfinancial.service.FaturamentoService;

import java.time.LocalDate;

@RestController
@RequestMapping("/stfinancial/faturamento")
public class FaturamentoController {
	
	@Autowired
	private FaturamentoService service;
	
	@Autowired
	private FaturamentoMapper mapper;


    
    @GetMapping("/buscar")
    public Faturamento buscarPorId(@RequestParam Long idContrato, @RequestParam String idHorasMes) {
    	return service.findByIdFaturamento(idContrato, idHorasMes);
    }
    
    @RequestMapping(path = "/salvarFaturamento" , method = RequestMethod.POST)
    public ResponseEntity<?> salvarFaturamento(@RequestBody FaturamentoRequest request) {
        System.out.println(request);
    	Faturamento con = mapper.toEntity(request);
    	return ResponseEntity.ok(service.inserirFaturamento(con));
    }
    @RequestMapping(path = "/alterarFaturamento" , method = RequestMethod.PUT)
    public ResponseEntity<?> alterarFaturamento(@RequestBody FaturamentoRequest request) {
    	Faturamento classe = mapper.toEntity(request);
    	return ResponseEntity.ok(service.alterarFaturamento(classe));
    }
    @RequestMapping(path = "/deletarFaturamento" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarFaturamento(@RequestParam Long idContrato, @RequestParam String idHorasMes) {
//    	Faturamento classe = mapper.toEntity(request);
    	return ResponseEntity.ok(service.deletarFaturamento(idContrato, idHorasMes));
    }
    @RequestMapping(path = "/listarFaturamentos" , method = RequestMethod.GET)
    public ResponseEntity<?> listar() {
    	return ResponseEntity.ok(service.listarFaturamentos());
    }
}
