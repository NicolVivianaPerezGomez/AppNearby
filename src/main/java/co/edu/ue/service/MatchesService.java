package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IMatchesDao;
import co.edu.ue.entity.Matches;

@Service
public class MatchesService implements IMatchesService {

	@Autowired
    IMatchesDao dao;

    public MatchesService(IMatchesDao matchesDao) {
        this.dao = matchesDao;
    }

    @Override
    public Matches guardarMatch(Matches match) {
        return dao.guardarMatch(match);
    }

    @Override
    public Matches actualizarMatch(Matches match) {
        return dao.actualizarMatch(match);
    }

    @Override
    public Matches eliminarMatch(int matId) {
        return dao.eliminarMatch(matId);
    }

    @Override
    public Matches encontrarporId(int matId) {
        return dao.encontrarporId(matId);
    }

    @Override
    public List<Matches> findAll() {
        return dao.findAll();
    }

	@Override
	public List<Matches> getAllMatches() {
		return dao.findAll();
	}

}
