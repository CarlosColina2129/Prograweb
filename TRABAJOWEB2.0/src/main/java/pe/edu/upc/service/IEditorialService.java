package pe.edu.upc.service;
import java.util.List;
import pe.edu.upc.entity.Editorial;

public interface IEditorialService {
	public void insertar(Editorial editorial);
	public List<Editorial> listar();
	public void eliminar(int idEditorial);
}
