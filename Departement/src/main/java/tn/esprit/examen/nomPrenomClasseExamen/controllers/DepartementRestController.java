package tn.esprit.examen.nomPrenomClasseExamen.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Departement;
import tn.esprit.examen.nomPrenomClasseExamen.services.IDepartementServices;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("departement")
@RestController
public class DepartementRestController {

    @Autowired
    private IDepartementServices departementService;

    @GetMapping(value = "getAllDep")
    public List<Departement> getAllDepartement(){
       return departementService.getAllDepartement();
    }
    @PostMapping(value = "addDepartement")
    public Departement addDepartement(@RequestBody Departement departement){
        return departementService.addDepartement(departement);
    }
    @PutMapping (value = "updateDepartement/{id}")
    public Departement updateDepartement(@RequestBody Departement departement, @PathVariable int id){
        return departementService.updateDepartement(departement,id);
    }
    @DeleteMapping(value = "deleteDepartement/{id}")
    public String deleteDepartement(@PathVariable int id){
        return departementService.deleteDepartementById(id);
    }
    @GetMapping(value = "depatementParNom/{nom}")
    public List<Departement> getDepartementParNom(@PathVariable String nom){
        return  departementService.getDepartementByNom(nom);
    }



}
