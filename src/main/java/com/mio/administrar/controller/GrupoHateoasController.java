package com.mio.administrar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mio.administrar.entity.GrupoHateoas;
import com.mio.administrar.repository.GrupoHateoasRepository;

@RestController
@RequestMapping(path="/grupoh", produces = "application/hal+json")
public class GrupoHateoasController  {
	@Autowired
	private GrupoHateoasRepository grupoHateoasRepository;
	
	/**
	 * Obtiene todos los grupos: GET http://{servidor}:{puerto}/grupoh
	 * @return Lista de grupos
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Iterable<GrupoHateoas> findAll() {
		return grupoHateoasRepository.findAll() ;
	}
	
	/**
	 * Obtiene un grupo por id: GET http://{servidor}:{puerto}/grupoh/{id}
	 * @param id Id del grupo. En la Url
	 * @return Un grupo
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public GrupoHateoas unGrupo(@PathVariable int id) {
		return grupoHateoasRepository.unGrupo(id);
	}
}
