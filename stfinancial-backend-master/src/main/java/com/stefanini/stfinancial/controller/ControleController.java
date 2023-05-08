package com.stefanini.stfinancial.controller;

import com.stefanini.stfinancial.mapper.ControleMapper;
import com.stefanini.stfinancial.model.Controle;
import com.stefanini.stfinancial.model.Patrimonio;
import com.stefanini.stfinancial.repository.ControleRepository;
import com.stefanini.stfinancial.request.ControleRequest;
import com.stefanini.stfinancial.request.PatrimonioRequest;
import com.stefanini.stfinancial.service.ControleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Date;


@RestController
@RequestMapping("/stfinancial/controle")
public class ControleController {

    @Autowired
    private ControleService service;

    @Autowired
    private ControleMapper mapper;

    @Autowired
    private ControleRepository controleRepository;

//    @GetMapping("/buscarContratoAtivo")
//    public Page<ControleService> buscarPorAtivo(Pageable paginacao) {
//        return service.findByContratoAtivo();
//    }

    @GetMapping("/buscarContratoInativo")
    public Page<Controle> buscarPorInativo(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size) {
        return service.findByContratoInativo(false, PageRequest.of(page, size));
    }

    @GetMapping("/buscarContratoAtivo")
    public Page<Controle> buscarPorAtivo(@RequestParam(defaultValue = "0") int page,
                                           @RequestParam(defaultValue = "10") int size) {
        return service.findByContratoAtivo(true, PageRequest.of(page, size));
    }

    @RequestMapping(path = "/alterarControle" , method = RequestMethod.PUT)
    public ResponseEntity<?> alterarControle(@RequestBody ControleRequest request) {
           Controle classe = mapper.toEntity(request);
            return ResponseEntity.ok(service.alterarControle(classe));
    }
    @DeleteMapping("/deletarControle")
    public ResponseEntity<?> delete(@RequestParam LocalDate mesComp, @RequestParam Long idControle, @RequestParam Long matricula, @RequestParam Long idPatrimonio) {
        service.atualizarContratoAtivo(String.valueOf(mesComp), idControle, matricula);
        return ResponseEntity.ok().build();
    }


    @RequestMapping(path = "/salvarControle" , method = RequestMethod.POST)
    public ResponseEntity<?> salvarControle(@RequestBody ControleRequest request) {
        Controle controle = mapper.toEntity(request);
        System.out.println(request);
        return ResponseEntity.ok(service.inserirControle(controle));
    }
}
//    @RequestMapping(path = "/alterarControle" , method = RequestMethod.PUT)
//    public ResponseEntity<?> alterarControle(@RequestBody ControleRequest request) {
//        Controle classe = mapper.toEntity(request);
//        return ResponseEntity.ok(service.alterarControle(classe));
//    }
//    @RequestMapping(path = "/deletarControle/{id}" , method = RequestMethod.DELETE)
//    public ResponseEntity<?> deletarControle(@PathVariable Long id) {
//// Posse classe = mapper.toEntity(req);
//        return ResponseEntity.ok(service.deletarControle(id));
//    }
////    @RequestMapping(path = "/listarControle" , method = RequestMethod.GET)
////    public ResponseEntity<?> listar() {
////        return ResponseEntity.ok(service.listarControle());
////    }
//}