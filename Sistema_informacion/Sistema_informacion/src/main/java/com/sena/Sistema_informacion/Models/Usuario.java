package com.sena.Sistema_informacion.Models;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="Usuario")
public class Usuario {

	@Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name="id_usuario", nullable=false, length = 36)
    private String id_usuario;
	
	@Column(name="Nombre_usuario", nullable=false, length = 50)
    private String Nombre_usuario;
	
	@Column(name="Tipo_documento", nullable=false, length = 3)
    private String Tipo_documento;
	
	@Column(name="Numero_documento", nullable=false, length = 11)
    private String Numero_documento;
	
	@Column(name="Fecha_nacimiento", nullable=false, length = 11)
    private Date Fecha_nacimiento;
	
	@Column(name="Contraseña", nullable=false, length = 25)
    private String Contraseña;
	
	@Column(name="Fecha_ultima_actualizacion_contraseña", nullable=false, length = 25)
    private Date Fecha_ultima_actualizacion_contraseña;
	
	@Column(name="Fecha_ultimo_inicio_sesion", nullable=false, length = 25)
    private Date Fecha_ultimo_inicio_sesion;
	
	@Column(name="Correo_electronico", nullable=false, length = 256)
    private String Correo_electronico;
	
	@Column(name="Notificacion", nullable=false, length = 25)
    private boolean Notificacion;
	
	@Column(name="Estado", nullable=false, length = 10)
    private String Estado;

	public Usuario() {
		super();
	}

	public Usuario(String id_usuario, String nombre_usuario, String tipo_documento, String numero_documento,
			Date fecha_nacimiento, String contraseña, Date fecha_ultima_actualizacion_contraseña,
			Date fecha_ultimo_inicio_sesion, String correo_electronico, boolean notificacion, String estado) {
		super();
		this.id_usuario = id_usuario;
		Nombre_usuario = nombre_usuario;
		Tipo_documento = tipo_documento;
		Numero_documento = numero_documento;
		Fecha_nacimiento = fecha_nacimiento;
		Contraseña = contraseña;
		Fecha_ultima_actualizacion_contraseña = fecha_ultima_actualizacion_contraseña;
		Fecha_ultimo_inicio_sesion = fecha_ultimo_inicio_sesion;
		Correo_electronico = correo_electronico;
		Notificacion = notificacion;
		Estado = estado;
	}

	public String getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(String id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre_usuario() {
		return Nombre_usuario;
	}

	public void setNombre_usuario(String nombre_usuario) {
		Nombre_usuario = nombre_usuario;
	}

	public String getTipo_documento() {
		return Tipo_documento;
	}

	public void setTipo_documento(String tipo_documento) {
		Tipo_documento = tipo_documento;
	}

	public String getNumero_documento() {
		return Numero_documento;
	}

	public void setNumero_documento(String numero_documento) {
		Numero_documento = numero_documento;
	}

	public Date getFecha_nacimiento() {
		return Fecha_nacimiento;
	}

	public void setFecha_nacimiento(Date fecha_nacimiento) {
		Fecha_nacimiento = fecha_nacimiento;
	}

	public String getContraseña() {
		return Contraseña;
	}

	public void setContraseña(String contraseña) {
		Contraseña = contraseña;
	}

	public Date getFecha_ultima_actualizacion_contraseña() {
		return Fecha_ultima_actualizacion_contraseña;
	}

	public void setFecha_ultima_actualizacion_contraseña(Date fecha_ultima_actualizacion_contraseña) {
		Fecha_ultima_actualizacion_contraseña = fecha_ultima_actualizacion_contraseña;
	}

	public Date getFecha_ultimo_inicio_sesion() {
		return Fecha_ultimo_inicio_sesion;
	}

	public void setFecha_ultimo_inicio_sesion(Date fecha_ultimo_inicio_sesion) {
		Fecha_ultimo_inicio_sesion = fecha_ultimo_inicio_sesion;
	}

	public String getCorreo_electronico() {
		return Correo_electronico;
	}

	public void setCorreo_electronico(String correo_electronico) {
		Correo_electronico = correo_electronico;
	}

	public boolean isNotificacion() {
		return Notificacion;
	}

	public void setNotificacion(boolean notificacion) {
		Notificacion = notificacion;
	}

	public String getEstado() {
		return Estado;
	}

	public void setEstado(String estado) {
		Estado = estado;
	}

}
