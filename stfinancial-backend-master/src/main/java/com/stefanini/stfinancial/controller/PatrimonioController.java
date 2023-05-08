package com.stefanini.stfinancial.controller;

import com.stefanini.stfinancial.mapper.PatrimonioMapper;
import com.stefanini.stfinancial.model.Controle;
import com.stefanini.stfinancial.model.Patrimonio;
import com.stefanini.stfinancial.request.PatrimonioRequest;
import com.stefanini.stfinancial.service.PatrimonioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("stfinancial/patrimonio")
public class PatrimonioController {

    @Autowired
    private PatrimonioService service;

    @Autowired
    private PatrimonioMapper mapper;

    @GetMapping("/buscarInativos")
    public Page<Patrimonio> buscarPorInativos(@RequestParam(defaultValue = "0") int page,
                                              @RequestParam(defaultValue = "10") int size) {
        return service.findByInativos(PageRequest.of(page, size));
    }


    @GetMapping("/buscarIndisponivel")
    public Page<Patrimonio> buscarPorIndisponivel(@RequestParam(defaultValue = "0") int page,
                                         @RequestParam(defaultValue = "10") int size) {
        return service.findByDisponivel(false, PageRequest.of(page, size));
    }
    @GetMapping("/buscarDisponivel")
    public Page<Patrimonio> buscarPorDisponivel(@RequestParam(defaultValue = "0") int page,
                                                  @RequestParam(defaultValue = "10") int size) {
        return service.findByDisponivel(true, PageRequest.of(page, size));
    }
    @GetMapping("/buscar/{idPatrimonio}")
    public Patrimonio buscarPorId(@PathVariable Long idPatrimonio) {
        return service.findByIdPatrimonio(idPatrimonio);
    }

    @RequestMapping(path = "/salvarPatrimonio" , method = RequestMethod.POST)
    public ResponseEntity<?> salvarPatrimonio(@RequestBody @Valid PatrimonioRequest request) {
        Patrimonio classe = mapper.toEntity(request);
        System.out.println(classe);
        return ResponseEntity.ok(service.inserirPatrimonio(classe));
    }

    @RequestMapping(path = "/alterarPatrimonio" , method = RequestMethod.PUT)
    public ResponseEntity<?> alterarOperacao(@RequestBody  PatrimonioRequest request) {
        Patrimonio classe = mapper.toEntity(request);
        return ResponseEntity.ok(service.alterarPatrimonio(classe));
    }

    @RequestMapping(path = "/deletarPatrimonioDescartado/{idPatrimonio}" , method = RequestMethod.DELETE)
    public ResponseEntity<?> deletarPatrimonioDescartado(@PathVariable Long idPatrimonio) {
        System.out.println(idPatrimonio);
        return ResponseEntity.ok(service.deletarPatrimonioDescartado(idPatrimonio));
    }
    @RequestMapping(path = "/listarPatrimonio" , method = RequestMethod.GET)
    public ResponseEntity<?> listar() {
        return ResponseEntity.ok(service.listarPatrimonios());
    }

}
