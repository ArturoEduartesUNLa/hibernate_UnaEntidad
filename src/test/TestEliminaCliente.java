package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestEliminaCliente {

	public static void main(String[] args) {
		ClienteABM abm = new ClienteABM();
		Cliente c = abm.traer(1L);
		System.out.println("cliente a eliminar: \n" + c);
		try {
			// Listar Clientes de la base de datos previo a eliminar
			System.out.println("Clientes:\n" + abm.traer());

			abm.eliminar(c.getIdCliente());

			// Listar Clientes de la base de datos posterior a eliminar
			System.out.println("Clientes:\n" + abm.traer());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
