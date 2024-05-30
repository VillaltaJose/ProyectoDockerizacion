package ec.edu.ups.ppw63.demo63.business;

import java.util.List;

import ec.edu.ups.ppw63.demo63.dao.FacturaDAO;
import ec.edu.ups.ppw63.demo63.model.Factura;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionFacturas {

	@Inject
	private FacturaDAO daoFactura;
	
	public void actualizarFactura(Factura factura) throws Exception {
		Factura cli = daoFactura.read(factura.getCodigo());
		if (cli != null){
			daoFactura.update(factura);
		}else {
			throw new Exception("Factura no existe");
		}
	}
	
	public void guardarFacturas(Factura factura) {
		System.out.println("Codigo: " + factura.getCodigo());
		Factura cli = daoFactura.read(factura.getCodigo());
		if (cli != null) {
			System.out.println("Este es: " + factura);
			daoFactura.update(factura);
		}else {
			daoFactura.insert(factura);
		}
	}
	
	public void borrarFactura(int codigo) {
		daoFactura.remove(codigo);
	}
	
	public List<Factura> getFacturas(){
		return daoFactura.getAll();
	}
}
