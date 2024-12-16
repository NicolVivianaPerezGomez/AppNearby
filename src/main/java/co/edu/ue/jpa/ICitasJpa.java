package co.edu.ue.jpa;

import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import co.edu.ue.entity.Citas;

public interface ICitasJpa extends JpaRepository<Citas, Integer> {
    Citas findByCitFecha(Date citFecha); // Cambiado de findByFecha a findByCitFecha
    Citas findByCitEstado(String citEstado); // Asegúrate de que este método también esté correcto
}