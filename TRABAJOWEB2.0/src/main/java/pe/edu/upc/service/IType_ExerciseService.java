package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Type_Exercise;

public interface IType_ExerciseService {

	public void insertar(Type_Exercise type_excercise);
	public List<Type_Exercise> listar();
	public void eliminar(int idType_Exercise);
}
