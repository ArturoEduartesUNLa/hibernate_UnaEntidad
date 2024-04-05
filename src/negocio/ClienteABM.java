package negocio;

import java.time.LocalDate;
import java.util.List;

import dao.ClienteDao;
import datos.Cliente;

public class ClienteABM {
	ClienteDao dao = new ClienteDao();

	public Cliente traer(long idCliente) {
		return dao.traer(idCliente);
	}

	public Cliente traer(int dni) {
		return dao.traer(dni);

	}

	public long agregar(String apellido, String nombre, int dni, LocalDate fechaDeNacimiento) throws Exception {
		Cliente cliente = traer(dni);

		if (cliente != null) {
			throw new Exception("Existe DNI: " + dni);
		}

		cliente = new Cliente(apellido, nombre, dni, fechaDeNacimiento);

		return dao.agregar(cliente);

	}

	public void modificar(Cliente c) throws Exception {
		/*
		 * si se actualiza dni, previamente verificar que no exista el DNI en la
		 * database
		 */
		if (traer(c.getDni()) != null) {
			throw new Exception("Ya existe DNI: " + c.getDni());
		}
		dao.actualizar(c);
	}

	public void eliminar(long idCliente) throws Exception {

		Cliente c = null;
		if ((c = traer(idCliente)) == null) {
			throw new Exception("Id no existe en BD: " + idCliente);
		}
		dao.eliminar(c);
	}

	public List<Cliente> traer() {
		return dao.traer();
	}
}
