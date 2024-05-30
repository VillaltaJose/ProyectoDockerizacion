package ec.edu.ups.ppw63.demo63.model;

public class CantidadFacturasClientes {

	private int codigoCliente;
	private String nombre;
	private int cantidad_facturas;
	public CantidadFacturasClientes(int codigoCliente, String nombre, int cantidad_facturas) {
		this.codigoCliente = codigoCliente;
		this.nombre = nombre;
		this.cantidad_facturas = cantidad_facturas;
	}
	public int getCodigoCliente() {
		return codigoCliente;
	}
	public void setCodigoCliente(int codigoCliente) {
		this.codigoCliente = codigoCliente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getCantidad_facturas() {
		return cantidad_facturas;
	}
	public void setCantidad_facturas(int cantidad_facturas) {
		this.cantidad_facturas = cantidad_facturas;
	}
	@Override
	public String toString() {
		return "CantidadFacturasClientes [codigoCliente=" + codigoCliente + ", nombre=" + nombre
				+ ", cantidad_facturas=" + cantidad_facturas + "]";
	}
	
	
}
