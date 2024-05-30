package ec.edu.ups.ppw63.demo63.business;

import java.util.List;

import ec.edu.ups.ppw63.demo63.dao.ClienteDAO;
import ec.edu.ups.ppw63.demo63.model.Cliente;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionClientes implements GestionClientesLocal, GestionClientesRemoto{

	private final Tracer tracer = GlobalTracer.get();

	@Inject
	private ClienteDAO daoCliente;
	
	public void actualizarCliente(Cliente cliente) throws Exception {		
		Cliente cli = daoCliente.read(cliente.getCodigo());
		if (cli != null){
			daoCliente.update(cliente);
		}else {
			throw new Exception("Cliente no existe");
		}
	}
	
	public void guardarClientes(Cliente cliente) {
		System.out.println("Codigo: " + cliente.getCodigo());
		Cliente cli = daoCliente.read(cliente.getCodigo());
		if (cli != null) {
			System.out.println("Este es: " + cliente);
			daoCliente.update(cliente);
		}else {
			daoCliente.insert(cliente);
		}
	}
	
	public Cliente getClientePorCedula(String cedula) throws Exception{
		if (cedula.length() != 10) 
			throw new Exception("Cedula incorrecta");
			
			return daoCliente.getClientePorCedula(cedula);
	}
	
	public Cliente getClientePorId(int codigo){
			return daoCliente.getClientePorId(codigo);
	}
	
	public void borrarCliente(int codigo) {
		daoCliente.remove(codigo);
	}
	
	public List<Cliente> getClientes(){
		Span span = tracer.buildSpan("getClientes").start();
		
        try {
            var clientes = daoCliente.getAll();
            return clientes;
        } finally {
            span.finish();
        }
	}
	
}
