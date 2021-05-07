package com.biblioteca.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.biblioteca.backend.apirest.models.entity.Prestamo;


public interface IPrestamoDao extends JpaRepository<Prestamo, String>{
	
	

}
