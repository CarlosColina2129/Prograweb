package pe.edu.upc.controller;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Forum;
import pe.edu.upc.service.IForumService;

@Named
@RequestScoped


public class ForumController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IForumService fService;
	private Forum forum;
	List<Forum> listaForums;
	
	@PostConstruct
	public void init() {
		this.listaForums = new ArrayList<Forum>();
		this.forum = new Forum();
		this.listar();
	}
	
	public String nuevoForum() {
		this.setForum(new Forum());
		return "forum.xhtml";
	}
	
	public void insertar() {
		try {
			fService.insertar(forum);
			limpiarForum();
			//this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	public void listar() {
		try {
			listaForums = fService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}		
	}
	
	public void limpiarForum() {
		this.init();
	}
	
	public void eliminar(Forum fo) {
		try {
			fService.eliminar(fo.getIdForums());
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}			
	}
	

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}

	public List<Forum> getListaForums() {
		return listaForums;
	}

	public void setListaForums(List<Forum> listaForums) {
		this.listaForums = listaForums;
	}
	
}
