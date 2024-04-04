package test;

import java.time.LocalDate;

import negocio.ClienteABM;

public class TestAgregarCliente {

	public static void main(String[] args) {
		ClienteABM abm = new ClienteABM();
		try {
			long ultimoIDCliente = abm.agregar("Apellido", "Nombre", 35000002, LocalDate.now());
			System.out.println("Id cliente: " + ultimoIDCliente);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
