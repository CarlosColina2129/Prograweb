package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IType_ExerciseDao;
import pe.edu.upc.entity.Type_Exercise;
import pe.edu.upc.service.IType_ExerciseService;

@Named
@RequestScoped
public class Type_ExerciseServiceImpl implements IType_ExerciseService, Serializable {
	
private static final long serialVersionUID = 1L;
	
	@Inject
	private IType_ExerciseDao mD;

	@Override
	public void insertar(Type_Exercise Type_Exercise) {
		mD.insertar(Type_Exercise);		
	}

	@Override
	public List<Type_Exercise> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idType_Exercise) {
		mD.eliminar(idType_Exercise);		
	}

}
