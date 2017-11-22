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
@Table(name="paisHateoas")
public class PaisHateoas implements Serializable  {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idPais;

	private String nombre;

	@OneToMany(mappedBy="paisHateoas")
	private List<PersonaHateoas> personaHateoas;
	
	public PaisHateoas() {
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