package co.edu.ue.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.Matches;

public interface IMatchesJpa extends JpaRepository<Matches, Integer> {

	// Interfaz para el uso con JPA
	    Matches findById(int id);
	    List<Matches> findAll();
	    Matches save(Matches match); //GUARDA Y ACTUALIZA
	    void delete(Matches match);
}