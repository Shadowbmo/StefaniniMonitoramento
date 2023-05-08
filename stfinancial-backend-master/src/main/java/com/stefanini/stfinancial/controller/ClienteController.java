package com.stefanini.stfinancial.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stefanini.stfinancial.mapper.ClienteMapper;
import com.stefanini.stfinancial.model.Cliente;
import com.stefanini.stfinancial.request.ClienteRequest;
import com.stefanini.stfinancial.service.ClienteService;

@RestController
@RequestMapping("/stfinancial/cliente")
public class ClienteController {
	
	@Autowired
	private ClienteService service;
	
	@Autowired
	private ClienteMapper mapper;


    
    @GetMapping("/buscar/{id}")
    public Cliente buscarPorId(@PathVariable Long id) {
    	return service.findByIdCliente(id);
    }
    
    @RequestMapping(path = "/salvarCliente" , method = RequestMethod.POST)
    public ResponseEntity<?> salvarCliente(@RequestBody ClienteRequest request) {
    	Cliente cel = mapper.toEntity(request);
    	return ResponseEntity.ok(service.inserirCliente(cel));
    }
    @RequestMapping(path = "/alterarCliente" , method = RequestMethod.PUT)
    public ResponseEntity<?> alterarCelula(@RequestBody ClienteRequest request) {
    	Cliente cel = mapper.toEntity(request);
    	return ResponseEntity.ok(service.alterarCliente(cel));
    }
    @RequestMapping(path = "/deletarCliente/{id}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarCelula(@PathVariable Long id) {
//    	Cliente cel = mapper.toEntity(request);
    	return ResponseEntity.ok(service.deletarCliente(id));
    }
    @RequestMapping(path = "/listarClientes" , method = RequestMethod.GET)
    public ResponseEntity<?> listar() {
    	return ResponseEntity.ok(service.listarClientes());
    }
}
