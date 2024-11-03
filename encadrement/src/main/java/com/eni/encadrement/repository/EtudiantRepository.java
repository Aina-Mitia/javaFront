package com.eni.encadrement.repository;

import com.eni.encadrement.model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtudiantRepository extends JpaRepository<Etudiant, String> {

    List<Etudiant> findEtudiantByNiveau(String niveau);

}