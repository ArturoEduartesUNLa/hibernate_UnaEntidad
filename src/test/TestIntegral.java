/*
 * En todos los casos se debe hacer el testeo correspondiente. Comenzar por archivos
separados y luego probar un testeo integral uniendo varios métodos, por ejemplo:
● Traer lista de clientes (para su visualización).
● Agregar un cliente nuevo.
● Traer el objeto del primer cliente.
● Modificar algún dato del cliente traído.
● Volver a mostrar la lista de clientes.
 * 
 */
package test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import datos.Cliente;
import negocio.ClienteABM;

public class TestIntegral {

	public static void main(String[] args) {
		ClienteABM abm = new ClienteABM();

		// Traer lista de clientes (para su visualización).
		System.out.println("Lista de clientes:\n" + abm.traer());

		// Agregar un cliente nuevo.
		int dni = LocalTime.now().getSecond();
		try {
			System.out.println("Id nuevo Cliente: " + abm.agregar("Garcia", "Charly", 35000000 + dni, LocalDate.now()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		// Traer el objeto del primer cliente.
		Cliente c = abm.traer(1L);

		// Modificar algún dato del cliente traído.
		c.setNombre("Mercedes");
		c.setApellido("Sosa");

		try {
			abm.modificar(c);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Traer otro objeto para testear Exception DNI existente.
		c = abm.traer(2L);
		c.setDni(35000021);
		try {
			abm.modificar(c);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Volver a mostrar la lista de clientes.
		List<Cliente> lstSortedIdCliente = abm.traer();
		
		lstSortedIdCliente.sort((c1,c2) -> (int)(c1.getIdCliente() - c2.getIdCliente()));
        
		System.out.println(lstSortedIdCliente);
		// End Test

	}

}
