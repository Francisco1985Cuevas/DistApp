package py.com.distapp.domain;

import java.util.Date;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Version;
import javax.validation.constraints.NotNull;

import py.com.distapp.model.enums.EstadoFacturaCompra;
import py.com.distapp.model.enums.TipoFactura;

@Entity(name = "Compra")
@Table(name = "compra")
public class Compra {
	
	@Id
	@GeneratedValue(
			strategy = GenerationType.IDENTITY
			)
	private Long id;
	
	@Version
	private Integer version;

	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fechaEmision;
	
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date fechaVencimiento;
	
	@NotNull
	private String NroComprobante;
	
	@NotNull
	private Long timbrado;
	
	@NotNull
	private Double total;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Proveedor proveedor;
	
	@NotNull
	private Double saldo;
	
	@NotNull
	private Double abonado;
	
	@NotNull
	private EstadoFacturaCompra estado;
	
	@NotNull
	private TipoFactura tipoFactura;

	public Date getFechaEmision() {
		return fechaEmision;
	}

	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}

	public void setFechaVencimiento(Date fechaVencimiento) {
		this.fechaVencimiento = fechaVencimiento;
	}

	public String getNroComprobante() {
		return NroComprobante;
	}

	public void setNroComprobante(String nroComprobante) {
		NroComprobante = nroComprobante;
	}

	public Long getTimbrado() {
		return timbrado;
	}

	public void setTimbrado(Long timbrado) {
		this.timbrado = timbrado;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public Proveedor getProveedor() {
		return proveedor;
	}

	public void setProveedor(Proveedor proveedor) {
		this.proveedor = proveedor;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public Double getAbonado() {
		return abonado;
	}

	public void setAbonado(Double abonado) {
		this.abonado = abonado;
	}

	public EstadoFacturaCompra getEstado() {
		return estado;
	}

	public void setEstado(EstadoFacturaCompra estado) {
		this.estado = estado;
	}

	public TipoFactura getTipoFactura() {
		return tipoFactura;
	}

	public void setTipoFactura(TipoFactura tipoFactura) {
		this.tipoFactura = tipoFactura;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}
	
	
	
		
	
	
	
	
	
}