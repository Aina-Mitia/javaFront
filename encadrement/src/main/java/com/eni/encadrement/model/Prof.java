package com.eni.encadrement.model;

import jakarta.persistence.*;
import org.springframework.transaction.annotation.Transactional;


@Entity
@Table(name="prof")
public class Prof {

    @Id
    private String IDProf;
    private String numMatricule;
    private String nom;
    private String prenom;
    private String grade;


    public String getMatricule() {
        return numMatricule;
    }

    @Transactional
    public void setMatricule(String matricule) {
        this.numMatricule = matricule;
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
    public String getIDProf() {
        return IDProf;
    }

    @Transactional
    public void setIDProf(String niveau) {
        this.IDProf = niveau;
    }
    public String getGrade() {
        return grade;
    }

    @Transactional
    public void setGrade(String parcours) {
        this.grade = parcours;
    }

    /*@OneToOne(mappedBy = "prof")
    private Etudiant etudiant;

    @ManyToOne
    @JoinColumn(name = "matricule")
    private Etudiant etud;*/
}
