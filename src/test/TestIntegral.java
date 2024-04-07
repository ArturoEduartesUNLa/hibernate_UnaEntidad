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
			System.out.println("Id nuevo Cliente: " + abm.agregar("Garcia", "Charly", 35000000 + dni,LocalDate.now()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		● Traer el objeto del primer cliente. ● Modificar
		 * algún dato del cliente traído. ● Volver a mostrar la lista de clientes.
		 */

	}

}
