package ec.edu.ups.ppw63.demo63.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Factura {
	
	@Id
	@GeneratedValue
	private int codigo;
	private String numero;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "codigo_cliente")
	private Cliente cliente;

	private double total;
	private Date fechaEmision;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="codigo_factura")
	private List<DetalleFactura> detalles;
	
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Date getFechaEmision() {
		return fechaEmision;
	}
	public void setFechaEmision(Date fechaEmision) {
		this.fechaEmision = fechaEmision;
	}
	public List<DetalleFactura> getDetalles() {
		return detalles;
	}
	public void setDetalles(List<DetalleFactura> detalles) {
		this.detalles = detalles;
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public void addDetalles (DetalleFactura detalle) {
		if (detalles == null)
			detalles = new ArrayList<DetalleFactura>();
			
			detalles.add(detalle);
	}
	@Override
	public String toString() {
		return "Factura [codigo=" + codigo + ", numero=" + numero + ", cliente=" + cliente + ", total=" + total
				+ ", fechaEmision=" + fechaEmision + ", detalles=" + detalles + "]";
	}
	
	
	
}
