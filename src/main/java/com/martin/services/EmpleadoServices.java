package com.martin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.dao.EmpleadoRepository;
import com.martin.entity.Empleado;

@Service
public class EmpleadoServices {
	@Autowired
	private EmpleadoRepository repo;
	
	public void registrar(Empleado e) {
		repo.save(e);
	}
	public void actualizar(Empleado e) {
		repo.save(e);
	}
	public List<Empleado> listarTodo(){
		return repo.findAll();
	}
	public void eliminarPorID(Integer cod) {
		repo.deleteById(cod);
	}
	public Empleado buscarPorID(Integer cod) {
		return repo.findById(cod).orElse(null);
	}
}
