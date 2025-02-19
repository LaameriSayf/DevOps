package tn.esprit.examen.nomPrenomClasseExamen.services;

import tn.esprit.examen.nomPrenomClasseExamen.entities.Departement;

import java.util.List;

public interface IDepartementServices {
    Departement addDepartement(Departement departement);
    List<Departement> getAllDepartement();
    Departement getDepartementById(int id);
    String deleteDepartementById(int id);
    Departement updateDepartement(Departement departement , int id);
    List<Departement> getDepartementByNom(String nom);
}
