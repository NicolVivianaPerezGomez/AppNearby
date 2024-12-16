package co.edu.ue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.ue.dao.IUsuariosDao;
import co.edu.ue.entity.Usuarios;

@Service
public class UsuariosService implements IUsuariosService {

    @Autowired
    private IUsuariosDao dao;

    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String NAME_REGEX = "^[A-Za-z\\s]+$";

    @Override
    public List<Usuarios> guardarUsuario(Usuarios usuario) {
        validarUsuario(usuario);
        return dao.guardarUsuarios(usuario);
    }

    @Override
    public Usuarios actualizarUsuario(Usuarios usuario) {
        validarUsuario(usuario);
        return dao.actualizarUsuarios(usuario);
    }

    @Override
    public Usuarios eliminarUsuario(int usuid) {
        return dao.eliminarUsuarios(usuid);
    }

    @Override
    public List<Usuarios> listaCompleta() {
        return dao.listaCompleta();
    }

    @Override
    public Usuarios busquedaPorId(int usuid) {
        return dao.busquedaporId(usuid);
    }

    @Override
    public Usuarios busquedaPorEmail(String usuEmail) {
        if (usuEmail == null || !usuEmail.matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("El email no es válido. Debe cumplir con el formato correcto.");
        }
        return dao.busquedaporEmail(usuEmail);
    }

    /**
     * Valida los datos de un usuario.
     * @param usuario El objeto de usuario a validar.
     */
    private void validarUsuario(Usuarios usuario) {
        if (usuario == null) {
            throw new IllegalArgumentException("El objeto usuario no puede ser null.");
        }

        if (usuario.getUsuNombre() == null || !usuario.getUsuNombre().matches(NAME_REGEX)) {
            throw new IllegalArgumentException("El nombre del usuario es inválido. Debe contener solo letras y espacios.");
        }

        if (usuario.getUsuEmail() == null || !usuario.getUsuEmail().matches(EMAIL_REGEX)) {
            throw new IllegalArgumentException("El email del usuario no es válido.");
        }
    }
}

