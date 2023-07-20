package com.martin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martin.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Integer>{
	
}
