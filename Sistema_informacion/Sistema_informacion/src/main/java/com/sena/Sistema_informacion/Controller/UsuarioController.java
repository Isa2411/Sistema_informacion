package com.sena.Sistema_informacion.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sena.Sistema_informacion.IService.IUsuarioService;
import com.sena.Sistema_informacion.Models.Usuario;

@RequestMapping("/api/Sistema_informacion/usuario")
@RestController
@CrossOrigin
public class UsuarioController {

	@Autowired
	private IUsuarioService UsuarioService;
	
	
	@PostMapping("/")
    public ResponseEntity<Object> save(@RequestBody Usuario Usuario) {
	
	if (Usuario.getNombre_usuario().equals("")) {
        
        return new ResponseEntity<>("El nombre del usuario es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }

    if (Usuario.getTipo_documento().equals("")) {
        
        return new ResponseEntity<>("El tipo de documento del usuario es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }

    if (Usuario.getNumero_documento().equals("")) {
        
        return new ResponseEntity<>("El nuemro de documento es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }

    if (Usuario.getFecha_nacimiento().equals("")) {
        
        return new ResponseEntity<>("La fecha de nacimiento es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }
    
    if (Usuario.getContraseña().equals("")) {
        
        return new ResponseEntity<>("La contraseña del usuario es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }
    
    if (Usuario.getFecha_ultima_actualizacion_contraseña().equals("")) {
        
        return new ResponseEntity<>("La fecha de actualización de contraseña es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }
    
    if (Usuario.getFecha_ultimo_inicio_sesion().equals("")) {
        
        return new ResponseEntity<>("La fecha de ultimo inicio de sesión es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }

    if (Usuario.getCorreo_electronico().equals("")) {
    
    	return new ResponseEntity<>("El correo electronico es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }
    
    if (!Usuario.isNotificacion()) {
        
    	return new ResponseEntity<>("La notificación es un campo obligatorio", HttpStatus.BAD_REQUEST);
    }
    
    UsuarioService.save(Usuario);
    return new ResponseEntity<>(Usuario, HttpStatus.OK);
	
	}
	
	@GetMapping("/")
	public ResponseEntity<Object> findAll(){
		var ListaUsuario=UsuarioService.findAll();
		return new ResponseEntity<>(ListaUsuario,HttpStatus.OK);
	}
	
	@GetMapping("/{id_usuario}")
	public ResponseEntity<Object> findOne(@PathVariable String id_usuario){
		var Usuario=UsuarioService.findOne(id_usuario);
		return new ResponseEntity<>(Usuario,HttpStatus.OK);
	}
	
	@DeleteMapping("/{id_usuario}")
	public ResponseEntity<Object> delete(@PathVariable String id_usuario){
		UsuarioService.delete(id_usuario);
		return new ResponseEntity<>("Registro eliminado",HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Object> update(@PathVariable String id, @ModelAttribute("Usuario") Usuario usuarioUpdate){
		var Usuario=UsuarioService.findOne(id).get();
		if (Usuario != null) {
			Usuario.setNombre_usuario(usuarioUpdate.getNombre_usuario());
			Usuario.setTipo_documento(usuarioUpdate.getTipo_documento());
			Usuario.setNumero_documento(usuarioUpdate.getNumero_documento());
			Usuario.setFecha_nacimiento(usuarioUpdate.getFecha_nacimiento());
			Usuario.setContraseña(usuarioUpdate.getContraseña());
			Usuario.setFecha_ultima_actualizacion_contraseña(usuarioUpdate.getFecha_ultima_actualizacion_contraseña());
			Usuario.setFecha_ultimo_inicio_sesion(usuarioUpdate.getFecha_ultimo_inicio_sesion());
			Usuario.setCorreo_electronico(usuarioUpdate.getCorreo_electronico());
			Usuario.setNotificacion(usuarioUpdate.isNotificacion());

			UsuarioService.save(Usuario);
			return new ResponseEntity<>(Usuario,HttpStatus.OK);
		}
		else {
		return new ResponseEntity<>("Error, usuario no encontrado",HttpStatus.BAD_REQUEST);
		}
	}
}
