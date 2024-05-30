package ec.edu.ups.ppw63.demo63.business;

import java.util.List;

import ec.edu.ups.ppw63.demo63.model.Cliente;
import jakarta.ejb.Remote;

@Remote
public interface GestionClientesRemoto {

	public void guardarClientes(Cliente cliente) throws Exception;
	public void actualizarCliente(Cliente cliente)throws Exception;
	public Cliente getClientePorCedula(String cedula) throws Exception;
	public Cliente getClientePorId(int codigo);
	public void borrarCliente(int codigo);
	public List<Cliente> getClientes();
}
