package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Level_Exercise;

public interface ILevel_ExerciseService {
	public void insertar(Level_Exercise level_exercise);
	public List<Level_Exercise> listar();
	public void eliminar(int idLevel_Exercise);
}
