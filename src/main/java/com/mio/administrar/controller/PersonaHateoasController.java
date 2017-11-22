package com.mio.administrar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.mio.administrar.entity.PersonaHateoas;
import com.mio.administrar.repository.PersonaHateoasRepository;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.*;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path="/personah", produces = "application/hal+json")
public class PersonaHateoasController  {
	@Autowired
	private PersonaHateoasRepository personaHateoasRepository;
	
	/**
	 * Obtiene todas las personas: GET http://{servidor}:{puerto}/personah
	 * @return Lista de personas
	 */
	@RequestMapping(method = RequestMethod.GET)
	public Resources<Resource<PersonaHateoas>> allPersonas() {
		List<PersonaHateoas> listPersonaHateoas = personaHateoasRepository.allPersonas();
		return personaToResource(listPersonaHateoas);
	}
	
	 /**
	 * Obtiene una person por id: GET http://{servidor}:{puerto}/personah/{id}
	 * @param id Id de la persona. En la Url
	 * @return Una persona
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Resource<PersonaHateoas> unaPersona(@PathVariable int id) {
		PersonaHateoas	personaHateoas	= personaHateoasRepository.unaPersona(id);
		return personaToResource(personaHateoas);
	}
	
	/**
	 * Recorre una lista de Personas para agregar links
	 * @param personas Lista de personas
	 * @return Resources
	 */
	private Resources<Resource<PersonaHateoas>> personaToResource(List<PersonaHateoas> personas) {
		Link selfLink = linkTo(methodOn(PersonaHateoasController.class).allPersonas()).withSelfRel();
		List<Resource<PersonaHateoas>> customerResources = personas.stream().map(persona -> personaToResource(persona)).collect(Collectors.toList());
		return new Resources<>(customerResources, selfLink);
	}

	/**
	 * Agrega links a Una persona
	 * @param persona Una persona
	 * @return Resource
	 */
	private Resource<PersonaHateoas> personaToResource(PersonaHateoas persona) {
		Link selfLink 	= linkTo(methodOn(PersonaHateoasController.class).unaPersona(persona.getIdPersona())).withSelfRel();
		Link grupoLink 	= linkTo(methodOn(GrupoHateoasController.class).unGrupo(persona.getIdGrupo() )).withRel("Grupo");
		Link paisLink 	= linkTo(methodOn(PaisHateoasController.class).unPais(persona.getIdPais() )).withRel("Pais");
		return new Resource<>(persona, selfLink,grupoLink,paisLink);
	}
}
