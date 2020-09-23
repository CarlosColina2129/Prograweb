package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IEditorialDao;
import pe.edu.upc.entity.Editorial;
import pe.edu.upc.service.IEditorialService;

@Named
@RequestScoped
public class EditorialServiceImpl implements IEditorialService, Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IEditorialDao mD;
	@Override
	public void insertar(Editorial editorial) {
		mD.insertar(editorial);
	}

	@Override
	public List<Editorial> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idEditorial) {
		mD.eliminar(idEditorial);
	}

}
