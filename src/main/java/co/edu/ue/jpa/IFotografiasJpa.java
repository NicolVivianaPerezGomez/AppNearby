package co.edu.ue.jpa;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.ue.entity.Fotografias;

public interface IFotografiasJpa extends JpaRepository<Fotografias, Integer> {

	Fotografias save(Date fot_fechaSubida);

}