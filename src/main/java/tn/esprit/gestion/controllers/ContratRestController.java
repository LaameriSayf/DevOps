package tn.esprit.gestion.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestion.entities.Contrat;
import tn.esprit.gestion.services.IContrat;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("examen")
@RestController
public class ContratRestController {
    private final IContrat services;

    @PostMapping("/add")
    public ResponseEntity<Contrat> add(@RequestBody Contrat contrat) {
        return ResponseEntity.ok(services.add(contrat));
    }

    @PutMapping("/update")
    public ResponseEntity<Contrat> update(@RequestBody Contrat contrat) {
        return ResponseEntity.ok(services.update(contrat));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        services.delete(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Contrat> getById(@PathVariable Long id) {
        return ResponseEntity.ok(services.getById(id));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Contrat>> getAll() {
        return ResponseEntity.ok(services.getAll());
    }

    @GetMapping("/filterBySalaire/{minSalaire}")
    public ResponseEntity<List<Contrat>> filterBySalaire(@PathVariable float minSalaire) {
        return ResponseEntity.ok(services.filterBySalaire(minSalaire));
    }

    @GetMapping("/salary")
    public ResponseEntity<String> calculateSalary(
            @RequestParam(required = false) String typeContrat,
            @RequestParam(defaultValue = "total") String mode) {
        return ResponseEntity.ok(services.calculateSalary(typeContrat, mode));
    }




}



