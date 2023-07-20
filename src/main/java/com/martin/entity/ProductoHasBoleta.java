package com.martin.entity;
import java.io.Serializable;
import jakarta.persistence.*;


@Entity
@Table(name = "tb_producto_has_boleta")
public class ProductoHasBoleta implements Serializable{
	@EmbeddedId
	private ProductoHasBoletaPK pk;
	
	
	//Relación MUCHOS  a UNO "Medicamento"
	@ManyToOne
	@JoinColumn(name="IDE_PRO",referencedColumnName = "IDE_PRO",insertable = false,updatable =false)
	private Producto productoH;//ASOCI.
	
	//Relación MUCHOS  a UNO "Boleta"
	@ManyToOne
	@JoinColumn(name="num_bol",referencedColumnName = "num_bol",insertable = false,updatable =false)
	private Boleta boleta;//ASOCI.
	
	@Column(name = "pre")
	private double precio;

	public ProductoHasBoletaPK getPk() {
		return pk;
	}

	public void setPk(ProductoHasBoletaPK pk) {
		this.pk = pk;
	}

	

	
	//método de tipo get/set
	public Producto getProductoH() {
		return productoH;
	}

	public void setProductoH(Producto productoH) {
		this.productoH = productoH;
	}

	public Boleta getBoleta() {
		return boleta;
	}

	public void setBoleta(Boleta boleta) {
		this.boleta = boleta;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
	
	
	
}
