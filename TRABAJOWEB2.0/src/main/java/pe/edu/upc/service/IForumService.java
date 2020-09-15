package pe.edu.upc.service;
import java.util.List;
import pe.edu.upc.entity.Forum;

public interface IForumService {
	
	public void insertar(Forum forum);
	public List<Forum> listar();
	public void eliminar(int idForum);
}
