package com.distapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="agencia")
public class Agencia extends BaseEntity{
	
	@Column(name="documento", nullable=false, length=50)
	private String documento;
	@Column(name="direccion", nullable=true, length=255)
	private String direccion;
	@Column(name="telefono", nullable=true, length=100)
	private String telefono;
	@Column(name="propietario", nullable=true, length=100)
	private String propietario;
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getPropietario() {
		return propietario;
	}
	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}
	
}
