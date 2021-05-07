package com.biblioteca.backend.apirest.controllers;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.biblioteca.backend.apirest.models.entity.Prestamo;
import com.biblioteca.backend.apirest.models.services.IPrestamoService;

@RestController
@RequestMapping("/api")
public class PrestamoRestController {
	
	@Autowired(required = true)
	private IPrestamoService prestamoService;
	
	@PostMapping("/prestamo")
	public ResponseEntity<?> create(@Valid @RequestBody Prestamo prestamo, BindingResult result) {

		Prestamo prestamoNew = null;

		Map<String, Object> response = new HashMap<>();

		if (result.hasErrors()) {

			List<String> errors = result.getFieldErrors().stream()
					.map(err -> "El campo '" + err.getField() + "' " + err.getDefaultMessage())
					.collect(Collectors.toList());

			response.put("errors", errors);
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		try {

			prestamoNew = prestamoService.crearPrestamo(prestamo);
		} catch (DataAccessException e) {
			response.put("mensaje", "Error al realizar el insert en la base de datos");
			response.put("error", e.getMessage().concat(": ").concat(e.getMostSpecificCause().getMessage()));
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}

		response.put("id", prestamoNew.getId());

		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}


}
