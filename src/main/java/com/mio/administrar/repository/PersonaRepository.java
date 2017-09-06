package com.mio.administrar.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.mio.administrar.entity.Persona;


@Transactional
public interface PersonaRepository extends CrudRepository<Persona, Long>{
	@Query("select p from Persona p where p.idPersona = ?1")
	Persona findPersona(int id);

}
