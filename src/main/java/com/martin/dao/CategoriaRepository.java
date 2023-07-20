package com.martin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.martin.entity.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
