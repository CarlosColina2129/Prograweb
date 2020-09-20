package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Type_Exercise;

public interface IType_ExerciseDao {
	public void insertar(Type_Exercise te);
	public List<Type_Exercise> listar();
	public void eliminar(int idType_Exercises);
}
