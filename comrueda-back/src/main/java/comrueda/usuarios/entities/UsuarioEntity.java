package comrueda.usuarios.entities;

import comrueda.common.entities.BaseEntity;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;

@MappedSuperclass
public abstract class UsuarioEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -6346305157765070732L;

	private String correo;
	private String password;
	private String nombre;

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

}
