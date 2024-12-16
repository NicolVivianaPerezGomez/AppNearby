package co.edu.ue.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IFotografiasDao;
import co.edu.ue.entity.Fotografias;

@Service
public class FotografiasService implements IFotografiasService {

    @Autowired
    private IFotografiasDao dao;

    @Override
    public Fotografias getFotografiaById(int fotId) {
        return dao.encontrarporId(fotId);
    }

    @Override
    public List<Fotografias> getAllFotografias() {
        return dao.findAll();
    }

    @Override
    public Fotografias guardarFotografia(Fotografias fotografia) {
        return dao.guardarfotografias(fotografia);
    }

    @Override
    public Fotografias eliminarFotografiaPorId(int fotId) {
        return dao.eliminarporelId(fotId);
    }

    @Override
    public Fotografias actualizarFotografiaPorFecha(Date fot_fechaSubida) {
        return dao.actualizarpoFecha(fot_fechaSubida);
    }
}

