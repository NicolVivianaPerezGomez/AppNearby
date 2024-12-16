package co.edu.ue.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.Matches;
import co.edu.ue.jpa.IMatchesJpa;

//Implementación de la capa DAO

@Repository
public class MatchesDao implements IMatchesDao {

	@Autowired
	private IMatchesJpa jpa;

	@Override
	public Matches guardarMatch(Matches match) {
		return jpa.save(match); // Este método maneja tanto la creación como la actualización
	}

	@Override
	public Matches eliminarMatch(int matId) {
		Matches match = jpa.findById(matId);
		if (match != null) {
			jpa.delete(match);
		}
		return match;
	}

	@Override
	public List<Matches> findAll() {
		return jpa.findAll();
	}

	@Override
	public Matches encontrarporId(int matId) {
		return jpa.findById(matId);
	}


	@Override
	public Matches actualizarMatch(Matches match) {
		return jpa.save(match);
	}
}
