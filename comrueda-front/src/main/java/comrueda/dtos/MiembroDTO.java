package comrueda.dtos;

import comrueda.entities.MiembroEntity;

import java.util.Date;

public class MiembroDTO {
	
	private Long id;
	private String correo;
	private String password;
	private String nombre;
	private Date fechaNacimimento;
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
