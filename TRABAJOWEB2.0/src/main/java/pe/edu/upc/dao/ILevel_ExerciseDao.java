package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Level_Exercise;

public interface ILevel_ExerciseDao {
	public void insertar(Level_Exercise le);
	public List<Level_Exercise> listar();
	public void eliminar(int idLevel_Exercises);
}
