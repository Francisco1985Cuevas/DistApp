package com.distapp.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "kits")
public class Kits extends BaseEntity{
	
	@NotNull
	@ManyToOne( fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Producto producto;
	@NotNull
	private Double cantidad;
	
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public Double getCantidad() {
		return cantidad;
	}
	public void setCantidad(Double cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
