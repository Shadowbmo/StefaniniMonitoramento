package com.stefanini.stfinancial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stefanini.stfinancial.mapper.HorasMesMapper;
import com.stefanini.stfinancial.model.HorasMes;
import com.stefanini.stfinancial.request.HorasMesRequest;
import com.stefanini.stfinancial.service.HorasMesService;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/stfinancial/horasmes")
public class HorasMesController {
	
	@Autowired
	private HorasMesService service;
	
	@Autowired
	private HorasMesMapper mapper;


    
//    @GetMapping("/buscar")
//    public ResponseEntity<?> buscarPorId(@RequestBody HorasMesRequest request) {
//    	return ResponseEntity.ok(service.buscarPorId(request));
//    }
    @GetMapping("/buscar/{mesComp}")
    public ResponseEntity<?> buscarPorMes(@PathVariable String mesComp) {
        LocalDate mes = LocalDate.of(
                Integer.parseInt(mesComp.substring(0, 4)),
                Integer.parseInt(mesComp.substring(5, 7)),
                01);
        return ResponseEntity.ok(service.buscarPorMes(mes));
    }
    
    @RequestMapping(path = "/salvarHorasMes" , method = RequestMethod.POST)
    public ResponseEntity<?> salvarHorasMes(@RequestBody HorasMesRequest request) {
    	HorasMes cel = mapper.toEntity(request);
    	return ResponseEntity.ok(service.inserirHorasMes(cel));
    }
    @RequestMapping(path = "/alterarHorasMes" , method = RequestMethod.PUT)
    public ResponseEntity<?> alterarHorasMes(@RequestBody HorasMesRequest request) {
    	HorasMes cel = mapper.toEntity(request);
    	return ResponseEntity.ok(service.alterarHorasMes(cel));
    }
    @Transactional
    @RequestMapping(path = "/deletarHorasMes/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarHorasMes(@PathVariable String id) {
        LocalDate mesComp = LocalDate.of(
                Integer.parseInt(id.substring(0, 4)),
                Integer.parseInt(id.substring(5, 7)),
                01);
//        try {
            return ResponseEntity.ok(service.deletarHorasMes(mesComp));
//        } catch (Exception e){
//            return ResponseEntity.internalServerError().build();
//        }
    }
    @RequestMapping(path = "/listar" , method = RequestMethod.GET)
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listarHorasMes());
    }
}
