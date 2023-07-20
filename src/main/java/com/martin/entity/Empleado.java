package com.martin.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;


@Entity
@Table(name = "TB_EMPLEADO")
public class Empleado {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_emp")
	private Integer codigo;
	@Column(name="ape_emp")
	private String apellido;
	@Column(name="dni")
	private int dni;
	@Temporal(TemporalType.DATE)
	@Column(name="fech_registro")
	private Date fecha;
	@Column(name="nom_emp")
	private String nombre;
	@Column(name="telf_emp")
	private int telf;
	
	@ManyToOne
	@JoinColumn(name="idrol")
	private Rol rol;
	
	@ManyToOne
	@JoinColumn(name="idUsuario")
	private Usuario empleadoU;
	//métodos de tipo get/set

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
		this.dni = dni;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getTelf() {
		return telf;
	}

	public void setTelf(int telf) {
		this.telf = telf;
	}

	public Rol getRol() {
		return rol;
	}

	public void setRol(Rol rol) {
		this.rol = rol;
	}

	public Usuario getEmpleadoU() {
		return empleadoU;
	}

	public void setEmpleadoU(Usuario empleadoU) {
		this.empleadoU = empleadoU;
	}
	
}
