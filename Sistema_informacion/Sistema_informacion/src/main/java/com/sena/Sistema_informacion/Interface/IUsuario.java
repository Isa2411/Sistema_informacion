package com.sena.Sistema_informacion.Interface;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.sena.Sistema_informacion.Models.Usuario;

public interface IUsuario extends CrudRepository<Usuario, String> {

	@Query("SELECT l FROM Usuario l WHERE l.Nombre_usuario LIKE %?1% OR l.Tipo_documento LIKE %?1% OR l.Numero_documento LIKE %?1% OR l.Fecha_nacimiento LIKE %?1% OR l.Contraseña LIKE %?1% OR l.Fecha_ultima_actualizacion_contraseña LIKE %?1% OR l.Fecha_ultimo_inicio_sesion LIKE %?1% OR l.Correo_electronico LIKE %?1% OR l.Notificacion LIKE %?1%")
	List<Usuario> filtroUsuario(String filtro);
	
}
