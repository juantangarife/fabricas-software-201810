package comrueda.dtos;

import comrueda.entities.UsuarioEntity;

public class UsuarioDTO {
	
	private Long id;
	private String name;
	private String cedula;

    public UsuarioDTO() {
    }

    public UsuarioDTO(UsuarioEntity usuario) {
        this.id = usuario.getId();
        this.name = usuario.getName();
        this.cedula = usuario.getCedula();
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

    public UsuarioEntity toEntity() {
    		UsuarioEntity entity = new UsuarioEntity();
        entity.setId(this.id);
        entity.setName(this.name);
        entity.setCedula(this.cedula);
        return entity;
    }
    
}
