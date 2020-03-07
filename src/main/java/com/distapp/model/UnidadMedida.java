package com.distapp.model;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "unidadmedida")
public class UnidadMedida extends BaseEntity{
	private double volumen;

	public double getVolumen() {
		return volumen;
	}

	public void setVolumen(double volumen) {
		this.volumen = volumen;
	}
	
}
