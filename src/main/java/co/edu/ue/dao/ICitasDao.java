package co.edu.ue.dao;

import java.util.Date;
import java.util.List;

import co.edu.ue.entity.Citas;

public interface ICitasDao { 
	List<Citas> listaCompleta(); 
	Citas guardarCitas(Citas cita); 
	Citas actualizarCitas(Citas cita); 
	Citas eliminarCitas(int citId); 

    // CONSULTAS
    Citas busquedaPorId(int citId); 
    Citas busquedaPorFecha(Date citFecha);
    Citas busquedaPorCitEstado(String citEstado);
}
