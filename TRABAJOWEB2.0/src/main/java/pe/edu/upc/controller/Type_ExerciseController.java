package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Type_Exercise;
import pe.edu.upc.service.IType_ExerciseService;

@Named
@RequestScoped
public class Type_ExerciseController implements Serializable {

private static final long serialVersionUID = 1L;
	
	@Inject
	private IType_ExerciseService tService;
	private Type_Exercise Type_Exercise;
	List<Type_Exercise> listaType_Exercises;
	
	@PostConstruct
	public void init() {
		this.listaType_Exercises = new ArrayList<Type_Exercise>();
		this.Type_Exercise = new Type_Exercise();
		this.listar();
	}
	
	public String nuevoTipoEjercicio() {
		this.setType_Exercise(new Type_Exercise());
		return "type_exercise.xhtml";
	}
	
	public void insertar() {
		try {
			tService.insertar(Type_Exercise);
			limpiarType_Exercise();
			//this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	public void listar() {
		try {
			listaType_Exercises = tService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}		
	}
	
	public void limpiarType_Exercise() {
		this.init();
	}
	
	public void eliminar(Type_Exercise ta) {
		try {
			tService.eliminar(ta.getIdType_Exercises());
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}			
	}
	

	public Type_Exercise getType_Exercise() {
		return Type_Exercise;
	}

	public void setType_Exercise(Type_Exercise Type_Exercise) {
		this.Type_Exercise = Type_Exercise;
	}

	public List<Type_Exercise> getListaType_Exercises() {
		return listaType_Exercises;
	}

	public void setListaType_Exercises(List<Type_Exercise> listaType_Exercises) {
		this.listaType_Exercises = listaType_Exercises;
	}
	
}
