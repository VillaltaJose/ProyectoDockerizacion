package ec.edu.ups.ppw63.demo63.business;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import ec.edu.ups.ppw63.demo63.dao.ClienteDAO;
import ec.edu.ups.ppw63.demo63.dao.FacturaDAO;
import ec.edu.ups.ppw63.demo63.model.CantidadFacturasClientes;
import ec.edu.ups.ppw63.demo63.model.Cliente;
import ec.edu.ups.ppw63.demo63.model.DetalleFactura;
import ec.edu.ups.ppw63.demo63.model.Factura;
import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup      //Hace que no espere a que un cliente lo llame sino que se ejecutara ni bien se lanza la aplicacion
public class GestionDatos {
	
	@Inject
	private ClienteDAO daoCliente;
	
	@Inject
	private FacturaDAO daoFactura;
	
	@PostConstruct
	public void init() {
System.out.println("iniciando");
		
		Cliente cliente = new Cliente();
		cliente.setCodigo(1);
		cliente.setDni("0107193708");
		cliente.setDireccion("Racar");
		cliente.setNombre("Daniel Collaguazo");
		
		daoCliente.insert(cliente);
		
		Factura factura = new Factura();
		factura.setCliente(cliente);
		factura.setNumero("001-001-00000001");
		factura.setFechaEmision(new Date());
		factura.setTotal(1000.52);
		
		
		
		DetalleFactura det = new DetalleFactura();
		det.setNombre("TV");
		det.setCantidad(2);
		det.setPrecio(100.50);
		
		factura.addDetalles(det);
		
		det = new DetalleFactura();
		det.setNombre("Cocina");
		det.setCantidad(1);
		det.setPrecio(150.50);
		
		factura.addDetalles(det);
		
		
		daoFactura.insert(factura);
		/*System.out.println("\n------------- Clientes");
		List<Cliente> list = daoCliente.getAll();
		for (Cliente cli: list) {
			System.out.println(cli.getCodigo() + "\t" + cli.getNombre());
		}*/
		System.out.println("\n------------- Facturas2");
		List<Factura> list2 = daoFactura.getAll();
		for (Factura fac: list2) {
			System.out.println(fac);
		}
		
		System.out.println("\n------------- TotalFacturas");
		List<CantidadFacturasClientes> list3 = daoFactura.getTotalFacturas();
		for (CantidadFacturasClientes fac: list3) {
			System.out.println(fac);
		}
	}
}
