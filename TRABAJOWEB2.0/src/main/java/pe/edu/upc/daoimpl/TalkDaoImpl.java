package pe.edu.upc.daoimpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ITalkDao;
import pe.edu.upc.entity.Talk;



public class TalkDaoImpl implements ITalkDao, Serializable {

	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "a")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Talk talk) {
		// TODO Auto-generated method stub
		try {
			em.persist(talk);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Talk> listar() {
		List<Talk> lista = new ArrayList<Talk>();
		try {
			Query q = em.createQuery("select m from Talk m");
			lista = (List<Talk>) q.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idTalk) {
		// TODO Auto-generated method stub
		
		Talk tal = new Talk();
		try {
			tal = em.getReference(Talk.class,idTalk);
			em.remove(tal);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	
	
	

}
