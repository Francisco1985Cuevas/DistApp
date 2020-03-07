package com.distapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;

@Entity
@Table(name = "producto")
public class Producto extends BaseEntity {

	@NotNull
	@Column(unique = true)
	private String codigo;
	@NotNull
	@Column(unique = true)
	private String codigobarras;
	@NotNull
	private UnidadMedida unidadmedida;
	@Null
	private Marca marca;
	@NotNull
	private Double precioventa;
	@NotNull
	private Double preciocosto;
	@NotNull
	private Float magen;
	@NotNull
	private Boolean eskit;

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getCodigobarras() {
		return codigobarras;
	}

	public void setCodigobarras(String codigobarras) {
		this.codigobarras = codigobarras;
	}

	public UnidadMedida getUnidadmedida() {
		return unidadmedida;
	}

	public void setUnidadmedida(UnidadMedida unidadmedida) {
		this.unidadmedida = unidadmedida;
	}

	public Double getPrecioventa() {
		return precioventa;
	}

	public void setPrecioventa(Double precioventa) {
		this.precioventa = precioventa;
	}

	public Double getPreciocosto() {
		return preciocosto;
	}

	public void setPreciocosto(Double preciocosto) {
		this.preciocosto = preciocosto;
	}

	public Float getMagen() {
		return magen;
	}

	public void setMagen(Float magen) {
		this.magen = magen;
	}

	public Boolean getEskit() {
		return eskit;
	}

	public void setEskit(Boolean eskit) {
		this.eskit = eskit;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	
	

}
