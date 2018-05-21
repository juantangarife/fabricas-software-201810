package comrueda.usuarios.miembros.dtos;

import comrueda.usuarios.dtos.LoginDTO;
import comrueda.usuarios.miembros.entities.MiembroEntity;

import java.util.Date;

public class MiembroDTO extends LoginDTO {
	
	private Long id;
	private String nombre;
	private Date fechaNacimimento;
	private String imagen;
	private boolean esAdministrador;

    public MiembroDTO() {
    }

    public MiembroDTO(MiembroEntity miembro) {
        this.id = miembro.getId();
        this.correo = miembro.getCorreo();
        this.password = miembro.getPassword();
        this.nombre = miembro.getNombre();
        this.fechaNacimimento = miembro.getFechaNacimiento();
        this.esAdministrador = miembro.getEsAdministrador();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFechaNacimimento() {
		return fechaNacimimento;
	}

	public void setFechaNacimimento(Date fechaNacimimento) {
		this.fechaNacimimento = fechaNacimimento;
	}

	public boolean isEsAdministrador() {
		return esAdministrador;
	}

	public void setEsAdministrador(boolean esAdministrador) {
		this.esAdministrador = esAdministrador;
	}

	public MiembroEntity toEntity() {
    	MiembroEntity entity = new MiembroEntity();
        entity.setId(this.id);
        entity.setCorreo(this.correo);
        entity.setPassword(this.password);
        entity.setNombre(this.nombre);
        entity.setFechaNacimiento(this.fechaNacimimento);
        entity.setEsAdministrador(this.esAdministrador);
        return entity;
    }
    
}
