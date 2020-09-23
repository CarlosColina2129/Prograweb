package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Editorial;
import pe.edu.upc.service.IEditorialService;

@Named
@RequestScoped

public class EditorialController implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IEditorialService EService;
	private Editorial editorial;
	List<Editorial> listaEditorial;
	
	@PostConstruct
	public void init() {
		this.listaEditorial = new ArrayList<Editorial>();
		this.editorial = new Editorial();
		this.listar();
	}
	
	public String nuevoEditorial() {
		this.setEditorial(new Editorial());
		return "editorial.xhtml";
	}
	
	public void insertar() {
		try {
			EService.insertar(editorial);
			limpiarEditorial();
			//this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	public void listar() {
		try {
			listaEditorial = EService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}		
	}
	
	public void limpiarEditorial() {
		this.init();
	}
	
	public void eliminar(Editorial edi) {
		try {
			EService.eliminar(edi.getIdEditorial());
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}			
	}
	
	public Editorial getEditorial() {
		return editorial;
	}

	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}

	public List<Editorial> getListaEditorial() {
		return listaEditorial;
	}

	public void setListaEditorial(List<Editorial> listaEditorial) {
		this.listaEditorial = listaEditorial;
	}
	
}
