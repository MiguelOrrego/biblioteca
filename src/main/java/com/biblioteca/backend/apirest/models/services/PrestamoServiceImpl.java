package com.biblioteca.backend.apirest.models.services;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.biblioteca.backend.apirest.models.dao.IPrestamoDao;
import com.biblioteca.backend.apirest.models.entity.Prestamo;

@Service
public class PrestamoServiceImpl implements IPrestamoService {
	
	@Autowired
	private IPrestamoDao prestamoRepository;
	

	@Override
	@Transactional
	public Prestamo crearPrestamo(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return prestamoRepository.save(prestamo);
	}


	

	
}
