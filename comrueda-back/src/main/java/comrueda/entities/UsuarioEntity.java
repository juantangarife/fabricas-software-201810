package comrueda.entities;

import java.io.Serializable;

import javax.persistence.Entity;

@Entity
public class UsuarioEntity extends BaseEntity implements Serializable {

	private static final long serialVersionUID = -6346305157765070732L;
	
	private String cedula;

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

}
