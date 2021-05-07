package com.biblioteca.backend.apirest.models.entity;
import java.io.Serializable;

import javax.persistence.*;

@Entity
@Table(name = "tipo_usuario")
public class TipoUsuario implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipoUsuario")
	private Long id;
	
	@Column(name = "nombre")
	private String name;

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
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

}
