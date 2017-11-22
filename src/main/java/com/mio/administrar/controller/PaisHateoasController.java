package com.mio.administrar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mio.administrar.entity.PaisHateoas;
import com.mio.administrar.repository.PaisHateoasRepository;

@RestController
@RequestMapping(path="/paish", produces = "application/hal+json")
public class PaisHateoasController  {
	@Autowired
	private PaisHateoasRepository paisHateoasRepository;
	
	/**
	 * Obtiene todos los paises: GET http://{servidor}:{puerto}/paish
	 * @return Lista de paises
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<PaisHateoas> findAll() {
		return paisHateoasRepository.findAll() ;
	}
	
	/**
	 * Obtiene un pais por id: GET http://{servidor}:{puerto}/paish/{id}
	 * @param id Id del pais. En la Url
	 * @return Un pais
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public PaisHateoas unPais(@PathVariable int id) {
		return paisHateoasRepository.unPais(id);
	}
}
