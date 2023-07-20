package com.martin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.dao.ClienteRepository;
import com.martin.entity.Cliente;
import com.martin.entity.Enlace;
import com.martin.entity.Usuario;

@Service
public class ClienteServices {

	@Autowired
	private ClienteRepository repo;
	
	public List<Cliente> listaPorApellido(String ape){
		return repo.listarClientePorApellido(ape);
	}
	

	public void Registrar (Cliente cliente) {
		 repo.save(cliente);
	}
	
	public void actualizar(Cliente c) {
		repo.save(c);
	}
	public void eliminar(Integer cli) {
		repo.deleteById(cli);
	}
	public Cliente buscarPorID(Integer cli) {
		return repo.findById(cli).orElse(null);
	}
	public List<Cliente> listarTodos(){
		return repo.findAll();
	}
}
