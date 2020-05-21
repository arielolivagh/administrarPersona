package com.mio.administrar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.mio.administrar.entity.Persona;
import com.mio.administrar.repository.PersonaRepository;

@RestController
@RequestMapping(path="/persona")
public class PersonaController {
	@Autowired
	private PersonaRepository personaRepository;
		
	/**
	 * Crea una persona: POST http://{servidor}:{puerto}/persona
	 * @param nombre Nombre de la persona
	 * @param edad Edad de la persona
	 * @param sexo Sexo de la persona
	 * @return mensaje de 'Agregado correctamente'
	 */
	@RequestMapping(method=RequestMethod.POST,produces={"application/json"})
	public String createPersona(@RequestParam String nombre,@RequestParam int edad,@RequestParam String sexo) {
		Persona p = new Persona();
		p.setNombre(nombre);
		p.setEdad(edad);
		p.setSexo(sexo);
		personaRepository.save(p);
		
        return "Agregado correctamente";
    }
	
	/**
	 * Obtiene todas las personas: GET http://{servidor}:{puerto}/persona
	 * @return Lista de personas
	 */
	@RequestMapping(method=RequestMethod.GET,produces={"application/json"})
	public Iterable<Persona> readPersonas() {
        return personaRepository.findAll();
    }
	
	/**
	 * Obtiene una person por id: GET http://{servidor}:{puerto}/persona/{id}
	 * @param id Id de la persona. En la Url
	 * @return Una personas
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.GET,produces={"application/json"})
	public Persona readPersona(@PathVariable("id") int id) {
        return personaRepository.findPersonaById(id);
    }
	
	/**
	 * Actualiza una persona por Id: PUT http://{servidor}:{puerto}/persona/{id}
	 * @param id Id de la persona. En la Url
	 * @param nombre Nombre de la persona
	 * @param edad Edad de la persona
	 * @param sexo Sexo de la person
	 * @return mensaje de 'Actualizado correctamente'
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PUT,produces={"application/json"})
	public String updatePersona(@RequestParam String nombre,@RequestParam int edad,@RequestParam String sexo,@PathVariable("id") int id) {
		Persona p = new Persona();
		p.setIdPersona(id);
		p.setNombre(nombre);
		p.setEdad(edad);
		p.setSexo(sexo);
		personaRepository.save(p);
        return "Actualizado correctamente";
    }
	
	/**
	 * Actualiza la edad de una persona por Id: PATCH http://{servidor}:{puerto}/persona/{id}
	 * @param id Id de la persona. En la Url
	 * @param edad Edad de la persona
	 * @return mensaje de 'Actualizando la edad correctamente'
	 */
	@RequestMapping(value="/{id}",method=RequestMethod.PATCH,produces={"application/json"})
	public String updateParcialPersona(@PathVariable("id") int id,@RequestParam  int edad) {
		Persona p = personaRepository.findPersona(id);
		p.setEdad(edad);
		personaRepository.save(p);
        return "Actualizando la edad correctamente";
    }
	
	/**
	 * Elimina todas las personas: DELETE http://{servidor}:{puerto}/persona
	 * @return mensaje de 'Todo eliminado correctamente'
	 */
	@RequestMapping(method=RequestMethod.DELETE,produces={"application/json"})
	public String deleteAllPersona() {
		personaRepository.deleteAll();
        return "Todo eliminado correctamente";
    }
	
	/**
	 * Elimina una persona por id: DELETE http://{servidor}:{puerto}/persona/{id}
	 * @param id Id de la persona. En la Url
	 * @return mensaje de 'Eliminado correctamente'
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE,produces={"application/json"})
	public String deletePersona(@PathVariable("id") int id) {
		Persona p = new Persona();
		p.setIdPersona(id);
		personaRepository.delete(p);
        return "Eliminado correctamente";
    }
		
}
