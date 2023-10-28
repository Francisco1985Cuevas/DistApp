package py.com.distapp.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import py.com.distapp.model.enums.TipoConfiguracion;

@Entity
@Table(name = "configuracion")
public class Configuracion extends BaseEntity{
	
	private TipoConfiguracion tipo;
	private String valor;
	private Boolean activo;
	public TipoConfiguracion getTipo() {
		return tipo;
	}
	public void setTipo(TipoConfiguracion tipo) {
		this.tipo = tipo;
	}
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}
	public Boolean getActivo() {
		return activo;
	}
	public void setActivo(Boolean activo) {
		this.activo = activo;
	}
	
	
}
