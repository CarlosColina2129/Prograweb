package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Talk;

public interface ITalkService {
	
	public void insertar(Talk talk);
	public List<Talk> listar();
	public void eliminar(int idTalk);
	
}
