package com.martin.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.martin.entity.Producto;

import jakarta.transaction.Transactional;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{
	public List<Producto>findByDescripcionStartingWith(String des);
}
