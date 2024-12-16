package co.edu.ue.dao;

import java.util.List;
import co.edu.ue.entity.Usuarios;

public interface IUsuariosDao { //DECLARACION DE METODOS ABSTRACTOS QUE NO TIENEN CUERPO O CONSTANTES

		   //DECLARAR METODOS PARA HACER EL CRUD
		    List<Usuarios> guardarUsuarios(Usuarios usuario);
		    Usuarios actualizarUsuarios(Usuarios usuario);
		    Usuarios eliminarUsuarios(int usuid);
		  //CONSULTAS
		    List<Usuarios>listaCompleta();
		    Usuarios busquedaporId(int usuid);
		    Usuarios busquedaporEmail(String usuEmail);
}
