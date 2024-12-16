package co.edu.ue.dao;

import java.util.Date;
import java.util.List;
import co.edu.ue.entity.Fotografias;
public interface IFotografiasDao {

	//CONSULTAS
	Fotografias encontrarporId(int fotId);
    List<Fotografias> findAll();
    
    //CRUD
    Fotografias guardarfotografias(Fotografias fotografia);
    Fotografias eliminarporelId(int fotId);
    Fotografias actualizarpoFecha(Date fot_fechaSubida);
	
	

}
