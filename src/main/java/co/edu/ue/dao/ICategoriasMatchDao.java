package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.CategoriasMatch;

public interface ICategoriasMatchDao {
	  //CRUD
	    CategoriasMatch guardarCategoria(CategoriasMatch categoria);
	    CategoriasMatch actualizarCategoria(CategoriasMatch categoria);
	    CategoriasMatch eliminarCategoria(int catMatId);
	    
	    //CONSULTAS
	    List<CategoriasMatch> findAll();
	    CategoriasMatch encontrarPorId(int catMatId);
	    
	}