package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Matches;

public interface IMatchesService {

	Matches guardarMatch(Matches match);

	Matches eliminarMatch(int matId);

	Matches encontrarporId(int matId);
	
	Matches actualizarMatch(Matches match);

	List<Matches> findAll();

	List<Matches> getAllMatches();


}
