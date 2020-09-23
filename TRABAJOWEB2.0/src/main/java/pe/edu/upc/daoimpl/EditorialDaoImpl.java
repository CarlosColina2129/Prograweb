package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IEditorialDao;

import pe.edu.upc.entity.Editorial;

public class EditorialDaoImpl implements IEditorialDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "a")
	private EntityManager em;
	
	
	@Transactional
	@Override
	public void insertar(Editorial editorial) {
		try {
			em.persist(editorial);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}	
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Editorial> listar() {
		List<Editorial> lista = new ArrayList<Editorial>();
		try {
			Query q = em.createQuery("select m from Editorial m");
			lista = (List<Editorial>) q.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idEditorial) {
		
		Editorial edi=new Editorial();
		
		try {
			edi = em.getReference(Editorial.class,idEditorial);
			em.remove(edi);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}	
		
	}
	
}
