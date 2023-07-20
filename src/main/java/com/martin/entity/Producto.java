package com.martin.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "PRODUCTO")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="IDE_PRO")
	private Integer codigo;
	@Column(name="DES_PRO")
	private String descripcion;
	@Column(name="PRE_PRO")
	private double pre_pro;
	@Column(name="STO_PRO")
	private int stock;
	
	//relación de uno a muchos
	@ManyToOne
	@JoinColumn(name="IDE_CAT")
	private Categoria catagoriaP;
	
	@JsonIgnore
	@OneToMany(mappedBy = "productoH")
	private List<ProductoHasBoleta> listaProductoHB;
	
	
	public Categoria getCatagoriaP() {
		return catagoriaP;
	}
	public void setCatagoriaP(Categoria catagoriaP) {
		this.catagoriaP = catagoriaP;
	}
	//métodos de tipo get/set
	
	
	public Integer getCodigo() {
		return codigo;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public List<ProductoHasBoleta> getListaProductoHB() {
		return listaProductoHB;
	}
	public void setListaProductoHB(List<ProductoHasBoleta> listaProductoHB) {
		this.listaProductoHB = listaProductoHB;
	}
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public double getPre_pro() {
		return pre_pro;
	}
	public void setPre_pro(double pre_pro) {
		this.pre_pro = pre_pro;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
}
