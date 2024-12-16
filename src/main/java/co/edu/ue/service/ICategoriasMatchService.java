package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.CategoriasMatch;

public interface ICategoriasMatchService {
    CategoriasMatch getById(int catMatId);
    List<CategoriasMatch> getAll();
    CategoriasMatch create(CategoriasMatch categoriasMatch);
    CategoriasMatch modify(CategoriasMatch categoriasMatch);
    CategoriasMatch remove(int catMatId);
	CategoriasMatch eliminarCategoria(int catMatId);
}
