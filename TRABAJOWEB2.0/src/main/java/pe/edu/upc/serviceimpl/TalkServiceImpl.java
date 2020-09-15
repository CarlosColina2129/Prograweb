package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ITalkDao;
import pe.edu.upc.entity.Talk;
import pe.edu.upc.service.ITalkService;

@Named
@RequestScoped


public class TalkServiceImpl implements ITalkService, Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ITalkDao mD;

	@Override
	public void insertar(Talk talk) {
		mD.insertar(talk);		
	}

	@Override
	public List<Talk> listar() {
		return mD.listar();
	}

	@Override
	public void eliminar(int idTalk) {
		mD.eliminar(idTalk);		
	}

}
