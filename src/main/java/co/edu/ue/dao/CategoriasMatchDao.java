package co.edu.ue.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import co.edu.ue.entity.CategoriasMatch;
import co.edu.ue.jpa.ICategoriasMatchJpa;
import java.util.List;


@Repository
public class CategoriasMatchDao implements ICategoriasMatchDao {

    @Autowired
    private ICategoriasMatchJpa jpa;

    @Override
    public CategoriasMatch guardarCategoria(CategoriasMatch categoria) {
        return jpa.save(categoria);
    }

    @Override
    public CategoriasMatch actualizarCategoria(CategoriasMatch categoria) {
        return jpa.save(categoria);
    }

    @Override
    public CategoriasMatch eliminarCategoria(int catMatId) {
        CategoriasMatch categoria = encontrarPorId(catMatId);
        if (categoria != null) {
            jpa.delete(categoria);
        }
        return categoria;
    }

    @Override
    public List<CategoriasMatch> findAll() {
        return jpa.findAll();
    }

    @Override
    public CategoriasMatch encontrarPorId(int catMatId) {
        return jpa.findById(catMatId).orElse(null);
    }
}
