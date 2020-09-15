package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Forum;

public interface IForumDao {
	public void insertar(Forum forum);
	public List<Forum> listar();
	public void eliminar(int idForum);
}
