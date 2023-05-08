package com.stefanini.stfinancial.controller;

import com.stefanini.stfinancial.config.security.TokenService;
import com.stefanini.stfinancial.dto.TokenDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stefanini.stfinancial.request.UsuarioRequest;
import com.stefanini.stfinancial.service.LoginService;

import lombok.AllArgsConstructor;

import javax.validation.Valid;

@RestController
@RequestMapping("/stfinancial/login")
@AllArgsConstructor
public class LoginController {

    @Autowired
    private AuthenticationManager authManager;

    @Autowired
    private TokenService tokenService;

//    @PostMapping
//    public Boolean getByLoginAndSenha(@RequestBody UsuarioRequest request) {
//      if(service.findByNomeSenha(request)) {
//    	  return true;
//      }else {
//    	  return false;
//      }
//    }

    @PostMapping
    public ResponseEntity<?> auth(@RequestBody UsuarioRequest form){
        UsernamePasswordAuthenticationToken loginData = form.converter();
        try {
            Authentication authentication = authManager.authenticate(loginData);
            String token = tokenService.generateToken(authentication);
            return ResponseEntity.status(HttpStatus.OK).body(new TokenDTO(token, "Bearer"));
        } catch (AuthenticationException e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }
}
