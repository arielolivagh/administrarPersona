package com.mio.administrar.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;
import com.mio.administrar.entity.GrupoHateoas;

@Transactional
public interface GrupoHateoasRepository extends CrudRepository<GrupoHateoas, Long>{
	@Query("select g from GrupoHateoas g where g.idGrupo = ?1")
	GrupoHateoas unGrupo(int id);
	
	@Query("select g from GrupoHateoas g")
	List<GrupoHateoas> allGrupos();
}
