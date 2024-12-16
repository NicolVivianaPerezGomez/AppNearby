package co.edu.ue.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.ue.entity.CategoriasMatch;

public interface ICategoriasMatchJpa extends JpaRepository<CategoriasMatch, Integer>{

	CategoriasMatch save(CategoriasMatch categoria);

	List<CategoriasMatch> findAll();

	CategoriasMatch findById(int matId);

	void delete(CategoriasMatch categoria);
}
