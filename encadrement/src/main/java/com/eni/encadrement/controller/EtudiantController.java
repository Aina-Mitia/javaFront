package com.eni.encadrement.controller;

import com.eni.encadrement.model.Etudiant;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.eni.encadrement.repository.EtudiantRepository;

import java.util.List;
import java.util.Optional;

@Controller
@RestController
@RequestMapping("/api/etudiant")
public class EtudiantController {

    final EtudiantRepository etudiantRepository;

    public EtudiantController(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @GetMapping
    public ResponseEntity<List<Etudiant>> getAllEtudiant() {
        return new ResponseEntity<>(etudiantRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping("/niveau/{niveau}")
    public ResponseEntity<List<Etudiant>> getEtudiantByNiveau(@PathVariable String niveau) {
        return new ResponseEntity<>(etudiantRepository.findEtudiantByNiveau(niveau),HttpStatus.OK);
    }

    @GetMapping("/lire/{id}")
    public ResponseEntity<Etudiant> getEtudiant(@PathVariable String id) {
        Optional<Etudiant> etudiant = etudiantRepository.findById(id);
        if(etudiant.isPresent()){
            return new ResponseEntity<>(etudiant.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

//    @GetMapping("/search/{nom}")
//    public ResponseEntity<List<Etudiant>> getEtudiantByName(@PathVariable String nom) {
//        List<Etudiant> etudiant = etudiantRepository.findEtudiantByName(nom);
//        if(!etudiant.isEmpty()) {
//            return new ResponseEntity<>(etudiant, HttpStatus.OK);
//        }
//        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//    }
    
    @PostMapping
    public ResponseEntity<Etudiant> createEtudiant(@RequestBody Etudiant etudiant) {
        Etudiant createdEtudiant = etudiantRepository.save(etudiant);
        return new ResponseEntity<>(createdEtudiant,HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Etudiant> updateEtudiant(@PathVariable String id, @RequestBody Etudiant etudiantDetails) {
        Optional<Etudiant> etudiantUpdated = etudiantRepository.findById(id);
        if(etudiantUpdated.isPresent()) {
            Etudiant etudiantExisting = etudiantUpdated.get();
            etudiantExisting.setNom(etudiantDetails.getNom());
            etudiantExisting.setPrenom(etudiantDetails.getPrenom());
            etudiantExisting.setNiveau(etudiantDetails.getNiveau());
            etudiantExisting.setParcours(etudiantDetails.getParcours());

            Etudiant updatedEtudiant = etudiantRepository.save(etudiantExisting);

            return new ResponseEntity<>(updatedEtudiant, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Etudiant> deleteEtudiant(@PathVariable String id) {
        Optional<Etudiant> etudiantASupprimer = etudiantRepository.findById(id);
        if(etudiantASupprimer.isPresent()) {
            etudiantRepository.delete(etudiantASupprimer.get());
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
