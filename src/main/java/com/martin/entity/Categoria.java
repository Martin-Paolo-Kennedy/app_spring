package com.martin.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="CATEGORIA")
public class Categoria {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDE_CAT")
	private Integer codigo;
	@Column(name="DES_CAT")
	private String des_cat;
	
	
	@JsonIgnore
	@OneToMany(mappedBy = "catagoriaP")
	private List<Producto> listaProducto;
	

	public List<Producto> getListaProducto() {
		return listaProducto;
	}
	public void setListaProducto(List<Producto> listaProducto) {
		this.listaProducto = listaProducto;
	}
	
	
	//métodos de tipo get/set
	public String getDes_cat() {
		return des_cat;
	}
	public Integer getCodigo() {
		return codigo;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	public void setDes_cat(String des_cat) {
		this.des_cat = des_cat;
	}

}
