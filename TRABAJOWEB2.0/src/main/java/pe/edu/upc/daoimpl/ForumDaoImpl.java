package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IForumDao;

import pe.edu.upc.entity.Forum;


public class ForumDaoImpl implements IForumDao, Serializable {

private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName = "a")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Forum forum) {
		try {
			em.persist(forum);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	
	@SuppressWarnings("unchecked")
	@Override
	public List<Forum> listar() {
		List<Forum> lista = new ArrayList<Forum>();
		try {
			Query q = em.createQuery("select m from Forum m");
			lista = (List<Forum>) q.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idForum) {
		
		Forum forumcito=new Forum();
		
		try {
			forumcito = em.getReference(Forum.class,idForum);
			em.remove(forumcito);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}				
	}
	
}
