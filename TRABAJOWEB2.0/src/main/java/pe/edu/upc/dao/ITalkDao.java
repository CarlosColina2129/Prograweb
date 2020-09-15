package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Talk;

public interface ITalkDao {
	public void insertar(Talk talk);
	public List<Talk> listar();
	public void eliminar(int idTalk);
}
