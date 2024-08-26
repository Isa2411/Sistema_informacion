package com.sena.Sistema_informacion.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sena.Sistema_informacion.IService.IUsuarioService;
import com.sena.Sistema_informacion.Interface.IUsuario;
import com.sena.Sistema_informacion.Models.Usuario;

@Service
public class UsuarioService implements IUsuarioService {
	
	@Autowired
	private IUsuario data;
	
	@Override
	public String save(Usuario Usuario) {
		data.save(Usuario);
		return Usuario.getId_usuario();
	}


	@Override
	public List<Usuario> findAll() {
		List<Usuario> ListaUsuario=
		(List<Usuario>) data.findAll();
		return ListaUsuario;
	}

	@Override
	public Optional<Usuario> findOne(String id) {
		Optional<Usuario> Usuario=data.findById(id);
		return Usuario;
	}


	@Override
	public int delete(String id_usuario) {
	    try {
	        data.deleteById(id_usuario);
	        return 1;
	    } catch (Exception e) {
	        e.printStackTrace();
	        return 0;
	    }
	}

}
