package com.stefanini.stfinancial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stefanini.stfinancial.mapper.AlocacaoProfissionaisMapper;
import com.stefanini.stfinancial.model.AlocacaoProfissionais;
import com.stefanini.stfinancial.request.AlocacaoProfissionaisRequest;
import com.stefanini.stfinancial.service.AlocacaoProfissionaisService;

import java.time.LocalDate;

@RestController
@RequestMapping("/stfinancial/alocacaoprofissionais")
public class AlocacaoProfissionaisController {
	
	@Autowired
	private AlocacaoProfissionaisService service;
	
	@Autowired
	private AlocacaoProfissionaisMapper mapper;


    
    @GetMapping("/buscar")
    public AlocacaoProfissionais buscarPorId(@RequestParam String idHorasMes, @RequestParam Long idContrato, @RequestParam Long matricula) {
        return service.findByIdAlocacaoProfissionais(idHorasMes, idContrato, matricula);
    }
    
    @RequestMapping(path = "/salvarAlocacaoProfissionais" , method = RequestMethod.POST)
    public ResponseEntity<?> salvarAlocacaoProfissionais(@RequestBody AlocacaoProfissionaisRequest request) {
    	AlocacaoProfissionais con = mapper.toEntity(request);
    	return ResponseEntity.ok(service.inserirAlocacaoProfissionais(con));
    }
    @RequestMapping(path = "/alterarAlocacaoProfissionais" , method = RequestMethod.PUT)
    public ResponseEntity<?> alterarAlocacaoProfissionais(@RequestBody AlocacaoProfissionaisRequest request) {
    	AlocacaoProfissionais classe = mapper.toEntity(request);
    	return ResponseEntity.ok(service.alterarAlocacaoProfissionais(classe));
    }
    @RequestMapping(path = "/deletarAlocacaoProfissionais" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarFaturamentoo(@RequestParam String idHorasMes, @RequestParam Long idContrato, @RequestParam Long matricula) {
//    	AlocacaoProfissionais classe = mapper.toEntity(request);
    	return ResponseEntity.ok(service.deletarAlocacaoProfissionais(idHorasMes, idContrato, matricula));
    }
    @RequestMapping(path = "/listarAlocacaoProfissionais" , method = RequestMethod.GET)
    public ResponseEntity<?> listar() {
    	return ResponseEntity.ok(service.listarAlocacaoProfissionais());
    }

    @RequestMapping(path = "/listarAlocacaoProfissionais/{mesComp}" , method = RequestMethod.GET)
    public ResponseEntity<?> listar(@PathVariable String mesComp) {
        LocalDate mes = LocalDate.of(
                Integer.parseInt(mesComp.substring(0, 4)),
                Integer.parseInt(mesComp.substring(5, 7)),
                01);
        return ResponseEntity.ok(service.listarAlocacaoProfissionaisByMes(mes));
    }
}
