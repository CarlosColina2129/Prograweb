package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ILevel_ExerciseDao;
import pe.edu.upc.entity.Level_Exercise;
import pe.edu.upc.service.ILevel_ExerciseService;

@Named
@RequestScoped
public class Level_ExerciseServiceImpl implements ILevel_ExerciseService, Serializable {
    
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ILevel_ExerciseDao mD;

	@Override
	public void insertar(Level_Exercise Level_Exercise) {
		mD.insertar(Level_Exercise);		
	}

	@Override
	public List<Level_Exercise> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idLevel_Exercise) {
		mD.eliminar(idLevel_Exercise);		
	}
}
