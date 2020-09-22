package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Level_Exercise;
import pe.edu.upc.service.ILevel_ExerciseService;

@Named
@RequestScoped
public class Level_ExerciseController implements Serializable {
    
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ILevel_ExerciseService tService;
	private Level_Exercise Level_Exercise;
	List<Level_Exercise> listaLevel_Exercises;
	
	@PostConstruct
	public void init() {
		this.listaLevel_Exercises = new ArrayList<Level_Exercise>();
		this.Level_Exercise = new Level_Exercise();
		this.listar();
	}
	
	public String nuevoTipoEjercicio() {
		this.setLevel_Exercise(new Level_Exercise());
		return "level_exercise.xhtml";
	}
	
	public void insertar() {
		try {
			tService.insertar(Level_Exercise);
			limpiarLevel_Exercise();
			//this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	public void listar() {
		try {
			listaLevel_Exercises = tService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}		
	}
	
	public void limpiarLevel_Exercise() {
		this.init();
	}
	
	public void eliminar(Level_Exercise ta) {
		try {
			tService.eliminar(ta.getIdLevel_Exercises());
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}			
	}
	

	public Level_Exercise getLevel_Exercise() {
		return Level_Exercise;
	}

	public void setLevel_Exercise(Level_Exercise Level_Exercise) {
		this.Level_Exercise = Level_Exercise;
	}

	public List<Level_Exercise> getListaLevel_Exercises() {
		return listaLevel_Exercises;
	}

	public void setListaLevel_Exercises(List<Level_Exercise> listaLevel_Exercises) {
		this.listaLevel_Exercises = listaLevel_Exercises;
	}
}
