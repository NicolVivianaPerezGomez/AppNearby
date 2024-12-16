package co.edu.ue.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import co.edu.ue.dao.ICitasDao;
import co.edu.ue.entity.Citas;
import java.util.Date;
import java.util.List;

@Service
public class CitasService implements ICitasService {
	
	 @Autowired
    ICitasDao dao;

    public CitasService(ICitasDao citasDao) {
        this.dao = citasDao;
    }

    @Override
    public List<Citas> listaCompleta() {
        return dao.listaCompleta();
    }

    @Override
    public Citas guardarCitas(Citas cita) {
        return dao.guardarCitas(cita);
    }

    @Override
    public Citas actualizarCitas(Citas cita) {
        return dao.actualizarCitas(cita);
    }

    @Override
    public Citas eliminarCitas(int citId) {
        return dao.eliminarCitas(citId);
    }

    @Override
    public Citas busquedaPorId(int citId) {
        return dao.busquedaPorId(citId);
    }

    @Override
    public Citas busquedaPorFecha(Date citFecha) {
        return dao.busquedaPorFecha(citFecha);
    }

    @Override
    public Citas busquedaPorCitEstado(String citEstado) {
        return dao.busquedaPorCitEstado(citEstado);
    }

}