package co.edu.ue.service;

import java.util.Date;
import java.util.List;

import co.edu.ue.entity.Fotografias;

public interface IFotografiasService {

	Fotografias getFotografiaById(int fotId);
    List<Fotografias> getAllFotografias();
    Fotografias guardarFotografia(Fotografias fotografia);
    Fotografias eliminarFotografiaPorId(int fotId);
    Fotografias actualizarFotografiaPorFecha(Date fot_fechaSubida);
}
