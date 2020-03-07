package com.distapp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "kits")
public class Kits extends BaseEntity{
	
	private Producto producto;
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
