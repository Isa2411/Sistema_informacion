package com.sena.Sistema_informacion.IService;

import java.util.List;
import java.util.Optional;

import com.sena.Sistema_informacion.Models.Usuario;

public interface IUsuarioService {

	public String save(Usuario Usuario);
	public List<Usuario> findAll();
	public Optional<Usuario> findOne(String id_usuario);
	public int delete(String id_usuario);

	
}
