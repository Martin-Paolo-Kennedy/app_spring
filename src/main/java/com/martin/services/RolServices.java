package com.martin.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.martin.dao.RolRepository;
import com.martin.entity.Rol;

@Service
public class RolServices {
	@Autowired
	private RolRepository repo;
	
	public List<Rol> listarTodo(){
		return repo.findAll();
	}
}
