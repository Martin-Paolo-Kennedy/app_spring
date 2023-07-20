package com.martin.entity;
import java.io.Serializable;

import jakarta.persistence.*;

@Embeddable
public class ProductoHasBoletaPK implements Serializable{
	
	@Column(name = "num_bol")
	private int numeroBoleta;
	@Column(name = "IDE_PRO")
	private int codigoProducto;
	
	public int getNumeroBoleta() {
		return numeroBoleta;
	}
	public void setNumeroBoleta(int numeroBoleta) {
		this.numeroBoleta = numeroBoleta;
	}
	
	public int getCodigoProducto() {
		return codigoProducto;
	}
	public void setCodigoProducto(int codigoProducto) {
		this.codigoProducto = codigoProducto;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + codigoProducto;
		result = prime * result + numeroBoleta;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductoHasBoletaPK other = (ProductoHasBoletaPK) obj;
		if (codigoProducto != other.codigoProducto)
			return false;
		if (numeroBoleta != other.numeroBoleta)
			return false;
		return true;
	}
	
}
