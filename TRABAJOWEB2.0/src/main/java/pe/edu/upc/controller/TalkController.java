package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;


import pe.edu.upc.entity.Talk;

import pe.edu.upc.service.ITalkService;

@Named
@RequestScoped



public class TalkController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITalkService tService;
	private Talk talk;
	List<Talk> listaTalks;
	
	@PostConstruct
	public void init() {
		this.listaTalks = new ArrayList<Talk>();
		this.talk = new Talk();
		this.listar();
	}
	
	public String nuevaCharla() {
		this.setTalk(new Talk());
		return "talk.xhtml";
	}
	
	public void insertar() {
		try {
			tService.insertar(talk);
			limpiarTalk();
			//this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
		
	public void listar() {
		try {
			listaTalks = tService.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}		
	}
	
	public void limpiarTalk() {
		this.init();
	}
	
	public void eliminar(Talk ta) {
		try {
			tService.eliminar(ta.getIdTalk());
			this.listar();
		}
		catch(Exception ex) {
			System.out.println(ex.getMessage());
		}			
	}
	

	public Talk getTalk() {
		return talk;
	}

	public void setTalk(Talk talk) {
		this.talk = talk;
	}

	public List<Talk> getListaTalks() {
		return listaTalks;
	}

	public void setListaTalks(List<Talk> listatalks) {
		this.listaTalks = listatalks;
	}
	
}
