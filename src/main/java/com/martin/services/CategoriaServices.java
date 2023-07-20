package com.martin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.dao.CategoriaRepository;
import com.martin.entity.Categoria;

@Service
public class CategoriaServices {
	@Autowired
	private CategoriaRepository repo;
	
	public List<Categoria> listarTodos(){
		return repo.findAll();
	}
}
