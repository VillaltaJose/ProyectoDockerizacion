package ec.edu.ups.ppw63.demo63.dao;

import java.util.ArrayList;
import java.util.List;

import ec.edu.ups.ppw63.demo63.model.CantidadFacturasClientes;
import ec.edu.ups.ppw63.demo63.model.Factura;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class FacturaDAO {
	
	@PersistenceContext
	private EntityManager em;

	public void insert(Factura factura) {
		em.persist(factura);
	}
		
	public void update(Factura factura) {
		em.merge(factura);	
	}

	public void remove(int codigo) {
		Factura factura = em.find(Factura.class, codigo);
		em.refresh(factura);
	}
	
	public Factura read(int codigo) {
		Factura factura = em.find(Factura.class, codigo);
		return factura;
	}
	
	public List<Factura> getAll(){
		String jpql = "SELECT f FROM Factura f"; //JPQL es sensible a mayusculas --- para realizar una consulta es similar pero hay q ue tener en cuenta que se tiene una variabe en lugar del alterisco y hay que referenciar a la entidad  no a la tabla
												 // Es decir se debe consultar en la entidad mas no directamente a una tabla de la base de datos 
												 // En lugar del * se coloca una variable, esa variable hace referencia al alias de la entidad
		Query q = em.createQuery(jpql, Factura.class);
		return q.getResultList();
	}
	
	public List<CantidadFacturasClientes> getTotalFacturas() {
		String sql = "SELECT f.codigo_cliente, c.nombre, COUNT(f.codigo) " +
                "FROM factura f, cliente c " +
                "WHERE f.codigo_cliente = c.codigo " +
                "GROUP BY f.codigo_cliente, c.nombre";
		
		Query q = em.createNativeQuery(sql);
		
		List<CantidadFacturasClientes> results = q.getResultList();
	    List<CantidadFacturasClientes> cantidadFacturasList = new ArrayList<CantidadFacturasClientes>();
	    
//	    for (CantidadFacturasClientes result : results) {
//	        cantidadFacturasList.add(result);
//	    }

	    return cantidadFacturasList;
	}
	
	public List<CantidadFacturasClientes> getTotalFacturas2() {
	    String sql = "SELECT f.codigo_cliente, c.nombre, COUNT(f.codigo) " +
	                 "FROM factura f, cliente c " +
	                 "WHERE f.codigo_cliente = c.codigo " +
	                 "GROUP BY f.codigo_cliente, c.nombre";

	    Query q = em.createNativeQuery(sql);

	    List<Object[]> results = q.getResultList();
	    List<CantidadFacturasClientes> cantidadFacturasList = new ArrayList<>();

	    for (Object[] result : results) {
	        int codigoCliente = ((Number) result[0]).intValue();
	        String nombre = (String) result[1];
	        int cantidad = ((Number) result[2]).intValue();

	        CantidadFacturasClientes cantidadFacturas = new CantidadFacturasClientes(codigoCliente, nombre, cantidad);
	        cantidadFacturasList.add(cantidadFacturas);
	    }

	    return cantidadFacturasList;
	}
}
