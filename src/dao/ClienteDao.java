package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import datos.Cliente;

public class ClienteDao {

	private static Session session;
	private Transaction tx;

	private void iniciaOperacion() throws HibernateException {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}

	private void manejaExcepcion(HibernateException he) throws HibernateException {
		tx.rollback();
		throw new HibernateException("Error en la capa de Acceso a Datos", he);
	}

	/*
	 * se modifica el tipo de retorno a long porque es el tipo 
	 * devuelto por el metodo save de la clase Session
	 */
	public long agregar(Cliente objeto) { 
		long id = 0;
		try {

			iniciaOperacion();
			// sentencia original: id = Integer.parseInt(session.save(objeto).toString());
			id = (long) session.save(objeto); // cast mas simple
			tx.commit();
			
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
		return id;
	}

	public void actualizar(Cliente objeto) {
		try {
			iniciaOperacion();
			session.update(objeto);
			tx.commit();
		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public void eliminar(Cliente objeto) {
		try {
			iniciaOperacion();
			session.delete(objeto);
			tx.commit();

		} catch (HibernateException he) {
			manejaExcepcion(he);
		} finally {
			session.close();
		}
	}

	public Cliente traer(long idCliente) {
		Cliente cliente = null;
		try {
			iniciaOperacion();
			cliente = session.get(Cliente.class, idCliente);
		} finally {
			session.close();
		}

		return cliente;
	}

	public Cliente traer(int dni) {
		Cliente cliente = null;
		try {
			iniciaOperacion();
			cliente = session.createQuery("from Cliente c where c.dni = :dni", Cliente.class).setParameter("dni", dni)
					.uniqueResult();
		} finally {
			session.close();
		}
		return cliente;

	}

	public List<Cliente> traer() {
		List<Cliente> lista = new ArrayList<Cliente>();
		try {
			iniciaOperacion();
			Query<Cliente> query = session.createQuery("from Cliente c order by c.apellido asc, c.nombre asc",
					Cliente.class);
			lista = query.getResultList();

		} finally {
			session.close();
		}
		return lista;
	}
	
}
