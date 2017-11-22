package com.mio.administrar.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="grupoHateoas")
public class GrupoHateoas implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idGrupo;

	private String nombre;

	@OneToMany(mappedBy="grupoHateoas")
	private List<PersonaHateoas> personaHateoas;
	
	public GrupoHateoas() {
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<PersonaHateoas> getPersonaHateoas() {
		return this.personaHateoas;
	}
}