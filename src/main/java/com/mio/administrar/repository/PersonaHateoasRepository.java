package com.mio.administrar.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.mio.administrar.entity.PersonaHateoas;

@Transactional
public interface PersonaHateoasRepository extends CrudRepository<PersonaHateoas, Long>{
	@Query("select p from PersonaHateoas p where p.idPersona = ?1")
	PersonaHateoas unaPersona(int id);
	
	@Query("select p from PersonaHateoas p")
	List<PersonaHateoas> allPersonas();
}
