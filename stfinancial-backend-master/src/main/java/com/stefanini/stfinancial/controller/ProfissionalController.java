package com.stefanini.stfinancial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stefanini.stfinancial.mapper.ProfissionalMapper;
import com.stefanini.stfinancial.model.Profissional;
import com.stefanini.stfinancial.request.ProfissionalRequest;
import com.stefanini.stfinancial.service.ProfissionalService;

import java.time.LocalDate;

@RestController
@RequestMapping("/stfinancial/profissional")
public class ProfissionalController {
	
	@Autowired
	private ProfissionalService service;
	
	@Autowired
	private ProfissionalMapper mapper;


    
    @GetMapping("/buscar")
    public Profissional buscarPorId(@RequestParam Long matricula, @RequestParam String idHorasMes) {
    	return service.findByIdProfissional(matricula, idHorasMes);
    }
    
    @RequestMapping(path = "/salvarProfissional" , method = RequestMethod.POST)
    public ResponseEntity<?> salvarProfissional(@RequestBody ProfissionalRequest request) {
    	Profissional classe = mapper.toEntity(request);
    	return ResponseEntity.ok(service.inserirProfissional(classe));
    }
    @RequestMapping(path = "/alterarProfissional" , method = RequestMethod.PUT)
    public ResponseEntity<?> alterarProfissional(@RequestBody ProfissionalRequest request) {
    	Profissional classe = mapper.toEntity(request);
    	return ResponseEntity.ok(service.alterarProfissional(classe));
    }
    @RequestMapping(path = "/deletarProfissional" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarProfissional(@RequestParam Long matricula, @RequestParam String idHorasMes) {
//    	Profissional classe = mapper.toEntity(request);
    	return ResponseEntity.ok(service.deletarProfissional(matricula, idHorasMes));
    }

    @RequestMapping(path = "/listarProfissionais" , method = RequestMethod.GET)
    public ResponseEntity<?> listar() {
            return ResponseEntity.ok(service.listarProfissionais());
    }

    @RequestMapping(path = "/listarProfissionais/{mesComp}" , method = RequestMethod.GET)
    public ResponseEntity<?> listar(@PathVariable String mesComp) {
            LocalDate mes = LocalDate.of(
                    Integer.parseInt(mesComp.substring(0, 4)),
                    Integer.parseInt(mesComp.substring(5, 7)),
                    01);
            return ResponseEntity.ok(service.listarProfissionaisByMes(mes));
    }
}
