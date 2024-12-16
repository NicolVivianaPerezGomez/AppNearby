package co.edu.ue.dao;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import co.edu.ue.entity.Fotografias;
import co.edu.ue.jpa.IFotografiasJpa;


    @Repository
    public class FotografiasDao implements IFotografiasDao {

        @Autowired
        private IFotografiasJpa jpa;

        @Override
        public Fotografias encontrarporId(int fotId) {
            return jpa.findById(fotId).orElse(null);
        }

        @Override
        public List<Fotografias> findAll() {
            return jpa.findAll();
        }

        @Override
        public Fotografias guardarfotografias(Fotografias fotografia) {
            return jpa.save(fotografia);
        }

        @Override
        public Fotografias eliminarporelId(int fotId) {
            Fotografias fotografia = encontrarporId(fotId);
            if (fotografia != null) {
                jpa.delete(fotografia);
            }
            return fotografia;
        }

		@Override
		public Fotografias actualizarpoFecha( Date fot_fechaSubida) {
			return jpa.save(fot_fechaSubida);
		}
		
    }
