package com.martin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martin.entity.ProductoHasBoleta;


public interface ProductoHasBoletaRepository extends
	JpaRepository<ProductoHasBoleta, Integer>{

}
