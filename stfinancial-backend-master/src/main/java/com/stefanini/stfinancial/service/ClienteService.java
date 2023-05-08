package com.stefanini.stfinancial.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stefanini.stfinancial.model.Cliente;
import com.stefanini.stfinancial.repository.ClienteRepository;
import com.stefanini.stfinancial.request.ClienteRequest;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ClienteService {

	@Autowired
	private final ClienteRepository repo;

	public Cliente findByIdCliente(Long id) {
		return repo.findById(id).get();
	}

	public Cliente inserirCliente(Cliente cliente) {
		return repo.save(cliente);
	}
	public List<Cliente> listarClientes() {
		return repo.findAll();
	}
	public Cliente alterarCliente(Cliente cliente) {
			return repo.save(cliente);
	}
	public String deletarCliente(Long id) {
//		Cliente cli = repo.findByIdCliente(.getIdCliente());
			repo.deleteById(id);
			return "Deletado com sucesso";
	}

}
