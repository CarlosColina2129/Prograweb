package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IForumDao;
import pe.edu.upc.entity.Forum;
import pe.edu.upc.service.IForumService;

@Named
@RequestScoped
public class ForumServiceImpl implements IForumService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IForumDao mD;

	@Override
	public void insertar(Forum forum) {
		mD.insertar(forum);		
	}

	@Override
	public List<Forum> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idForum) {
		mD.eliminar(idForum);		
	}
}
