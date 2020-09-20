package pe.edu.upc.daoimpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IType_ExerciseDao;
import pe.edu.upc.entity.Talk;
import pe.edu.upc.entity.Type_Exercise;

public class Type_ExerciseDaoImpl implements IType_ExerciseDao, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "a")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Type_Exercise te) {
		// TODO Auto-generated method stub
		try {
			em.persist(te);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Type_Exercise> listar() {
		// TODO Auto-generated method stub
		List<Type_Exercise> lista = new ArrayList<Type_Exercise>();
		try {
			Query q = em.createQuery("select m from Type_Exercise m");
			lista = (List<Type_Exercise>) q.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idType_Exercises) {
		// TODO Auto-generated method stub
		Type_Exercise type_e = new Type_Exercise();
		try {
			type_e = em.getReference(Type_Exercise.class,idType_Exercises);
			em.remove(type_e);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
