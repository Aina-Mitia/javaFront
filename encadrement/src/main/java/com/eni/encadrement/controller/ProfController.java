package com.eni.encadrement.controller;

import com.eni.encadrement.model.Etudiant;
import com.eni.encadrement.model.Prof;
import com.eni.encadrement.repository.ProfRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.eni.encadrement.repository.EtudiantRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/prof")
public class ProfController {
    final ProfRepository profRepository;

    public ProfController(ProfRepository profRepository) {
        this.profRepository = profRepository;
    }

    @GetMapping("/api")
    public ResponseEntity<List<Prof>> getAllProf() {
        return new ResponseEntity<>(profRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/lire/{id}")
    public ResponseEntity<Prof> getProf(@PathVariable String id) {
        Optional<Prof> etudiant = profRepository.findById(id);
        if(etudiant.isPresent()){
            return new ResponseEntity<>(etudiant.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Prof> createProf(@RequestBody Prof etudiant) {
        Prof createdEtudiant = profRepository.save(etudiant);
        return new ResponseEntity<>(createdEtudiant,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Prof> updateProf(@PathVariable String id, @RequestBody Prof etudiantDetails) {
        Optional<Prof> etudiantUpdated = profRepository.findById(id);
        if(etudiantUpdated.isPresent()) {
            Prof etudiantExisting = etudiantUpdated.get();
            etudiantExisting.setIDProf(etudiantDetails.getIDProf());
            etudiantExisting.setMatricule(etudiantDetails.getMatricule());
            etudiantExisting.setNom(etudiantDetails.getNom());
            etudiantExisting.setPrenom(etudiantDetails.getPrenom());
            etudiantExisting.setGrade(etudiantDetails.getGrade());

            Prof updatedEtudiant = profRepository.save(etudiantExisting);

            return new ResponseEntity<>(updatedEtudiant, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Prof> deleteProf(@PathVariable String id) {
        Optional<Prof> etudiantASupprimer = profRepository.findById(id);
        if(etudiantASupprimer.isPresent()) {
            profRepository.delete(etudiantASupprimer.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    //le etrangere ny prof no mankany am etudiant
}
