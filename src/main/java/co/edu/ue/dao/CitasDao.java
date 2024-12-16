package co.edu.ue.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.ue.entity.Citas;
import co.edu.ue.jpa.ICitasJpa;
import java.util.Date;
import java.util.List;

@Repository
public class CitasDao implements ICitasDao {

    @Autowired
    private ICitasJpa jpa;

    @Override
    public List<Citas> listaCompleta() {
        return jpa.findAll();
    }

    @Override
    public Citas guardarCitas(Citas cita) {
        return jpa.save(cita);
    }

    @Override
    public Citas actualizarCitas(Citas cita) {
        return jpa.save(cita); // save GUARDA Y ACTUALIZA
    }

    @Override
    public Citas eliminarCitas(int citId) {
        Citas cita = busquedaPorId(citId);
        if (cita != null) {
            jpa.delete(cita);
        }
        return cita;
    }

    @Override
    public Citas busquedaPorId(int citId) {
        return jpa.findById(citId).orElse(null); 
    }

    @Override
    public Citas busquedaPorFecha(Date citFecha) {
        return jpa.findByCitFecha(citFecha); // JPA SE INTANCIA YA QUE NO LO MAPEA
    }

    @Override
    public Citas busquedaPorCitEstado(String citEstado) {
        return jpa.findByCitEstado(citEstado); // JPA SE INTANCIA YA QUE NO LO MAPEA
    }

}
