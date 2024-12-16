package co.edu.ue.service;

import java.util.List;

import co.edu.ue.dao.ICategoriasMatchDao;
import co.edu.ue.entity.CategoriasMatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriasMatchService implements ICategoriasMatchService {

	    @Autowired
	     ICategoriasMatchDao dao;

	    @Override
	    public CategoriasMatch getById(int catMatId) {
	        return dao.encontrarPorId(catMatId);
	    }

	    @Override
	    public List<CategoriasMatch> getAll() {
	        return dao.findAll();
	    }

	    @Override
	    public CategoriasMatch create(CategoriasMatch categoriasMatch) {
	        return dao.guardarCategoria(categoriasMatch);
	    }

	    @Override
	    public CategoriasMatch modify(CategoriasMatch categoriasMatch) {
	        return dao.actualizarCategoria(categoriasMatch);
	    }

	    @Override
	    public CategoriasMatch remove(int catMatId) {
	        return dao.eliminarCategoria(catMatId);
	    }

		@Override
		public CategoriasMatch eliminarCategoria(int catMatId) {
		return dao.eliminarCategoria(catMatId);
		}
}
