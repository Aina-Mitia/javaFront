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
    //ny cle etrangere ny prof no mankany am etudiant
}
