package test;

import datos.Cliente;
import negocio.ClienteABM;

public class TestActualizaCliente {

	public static void main(String[] args) {

		ClienteABM abm = new ClienteABM();

		Cliente cliente = abm.traer(1L);
		System.out.println("cliente a modificar: \n" + cliente);

		cliente.setDni(35000004);
		try {
			abm.modificar(cliente);
			System.out.println("Cliente Modif.:" + abm.traer(35000004));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
