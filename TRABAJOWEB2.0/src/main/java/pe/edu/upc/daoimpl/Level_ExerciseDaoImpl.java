package pe.edu.upc.daoimpl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ILevel_ExerciseDao;
import pe.edu.upc.entity.Level_Exercise;

public class Level_ExerciseDaoImpl implements ILevel_ExerciseDao, Serializable {
	
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName = "a")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Level_Exercise te) {
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
	public List<Level_Exercise> listar() {
		// TODO Auto-generated method stub
		List<Level_Exercise> lista = new ArrayList<Level_Exercise>();
		try {
			Query q = em.createQuery("select m from Level_Exercise m");
			lista = (List<Level_Exercise>) q.getResultList();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return lista;
	}

	@Transactional
	@Override
	public void eliminar(int idLevel_Exercises) {
		// TODO Auto-generated method stub
		Level_Exercise type_e = new Level_Exercise();
		try {
			type_e = em.getReference(Level_Exercise.class,idLevel_Exercises);
			em.remove(type_e);
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
