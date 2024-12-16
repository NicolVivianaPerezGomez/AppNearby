package co.edu.ue.service;

import java.util.List;

import co.edu.ue.entity.Usuarios;

public interface IUsuariosService { //EL INTERFACE ES UN CONTRATO QUE DEBE CUMPLIR LA CLASE QUE LA IMPLEMENTE
		    List<Usuarios> guardarUsuario(Usuarios usuario);
		    
		    Usuarios actualizarUsuario(Usuarios usuario);
		    
		    Usuarios eliminarUsuario(int usuId);
		    
		    List<Usuarios> listaCompleta();
		    
		    Usuarios busquedaPorId(int usuid);
		    
		    Usuarios busquedaPorEmail(String usuEmail);

}
