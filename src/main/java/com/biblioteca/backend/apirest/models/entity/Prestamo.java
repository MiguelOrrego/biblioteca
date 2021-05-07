package com.biblioteca.backend.apirest.models.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "prestamo")
public class Prestamo implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, length = 10)
	private String isbn;

	@Column(unique = true, length = 10)
	private String identificacionUsuario;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipoUsuario")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private TipoUsuario usuario;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIdentificacionUsuario() {
		return identificacionUsuario;
	}

	public void setIdentificacionUsuario(String identificacionUsuario) {
		this.identificacionUsuario = identificacionUsuario;
	}

	

	public TipoUsuario getUsuario() {
		return usuario;
	}

	public void setUsuario(TipoUsuario usuario) {
		this.usuario = usuario;
	}



	private static final long serialVersionUID = 1L;

}
