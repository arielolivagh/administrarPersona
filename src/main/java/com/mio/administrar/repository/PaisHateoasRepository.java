package com.mio.administrar.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.mio.administrar.entity.PaisHateoas;

@Transactional
public interface PaisHateoasRepository extends CrudRepository<PaisHateoas, Long>{
	@Query("select p from PaisHateoas p where p.idPais = ?1")
	PaisHateoas unPais(int id);
	
	@Query("select p from PaisHateoas p")
	List<PaisHateoas> allPaises();
}
