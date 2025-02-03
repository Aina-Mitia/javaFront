package com.eni.encadrement.model;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Entity
@Table(name="etudiant")
public class Etudiant {
	
	@Id
	private String matricule;

	private String nom;
	private String prenom;
	private String niveau;
	private String parcours;
	
	
	public String getMatricule() {
		return matricule;
	}

	@Transactional
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	public String getNom() {
		return nom;
	}

	@Transactional
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}

	@Transactional
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNiveau() {
		return niveau;
	}

	@Transactional
	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	public String getParcours() {
		return parcours;
	}

	@Transactional
	public void setParcours(String parcours) {
		this.parcours = parcours;
	}


	
}
