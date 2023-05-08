package com.stefanini.stfinancial.request;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LoginRequest implements Serializable{
	
	private static final long serialVersionUID = 6017547239678754027L;
	
	private String nome;
	private String senha;
}
