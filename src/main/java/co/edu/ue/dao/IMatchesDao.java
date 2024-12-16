package co.edu.ue.dao;

import java.util.List;

import co.edu.ue.entity.Matches;

public interface IMatchesDao {

	// METODOS CRUD
	Matches guardarMatch(Matches match);

	Matches actualizarMatch(Matches match);

	Matches eliminarMatch(int matId);

	// CONSULTAS
	List<Matches> findAll();

	Matches encontrarporId(int matId);

}
