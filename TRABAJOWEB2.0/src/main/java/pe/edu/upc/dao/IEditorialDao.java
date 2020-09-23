package pe.edu.upc.dao;
import java.util.List;

import pe.edu.upc.entity.Editorial;

public interface IEditorialDao {
	public void insertar(Editorial editorial);
	public List<Editorial> listar();
	public void eliminar(int idEditorial);
}
