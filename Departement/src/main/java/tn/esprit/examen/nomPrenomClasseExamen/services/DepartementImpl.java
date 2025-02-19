package tn.esprit.examen.nomPrenomClasseExamen.services;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Departement;
import tn.esprit.examen.nomPrenomClasseExamen.repositories.IDepartementRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class DepartementImpl implements IDepartementServices{
    final IDepartementRepository departementRepository;

    @Override
    public Departement addDepartement(Departement departement) {
       return departementRepository.save(departement);

    }

    @Override
    public List<Departement> getAllDepartement() {
        return departementRepository.findAll();
    }

    @Override
    public Departement getDepartementById(int id) {
        if (departementRepository.findById(id).isPresent()) {
            return departementRepository.findById(id).get();
        }else return null;
    }

    @Override
    public String deleteDepartementById(int id) {
        if (departementRepository.findById(id).isPresent()) {
            departementRepository.deleteById(id);
            return "Departement deleted sucess";
        }else return "Departement not found";



    }

    @Override
    public Departement updateDepartement(Departement departement , int id) {
            if (departementRepository.findById(id).isPresent()) {
                Departement existingdepartement= departementRepository.findById(id).get();
                existingdepartement.setName(departement.getName());
                return departementRepository.save(existingdepartement);
            }else return null;
    }

    @Override
    public List<Departement> getDepartementByNom(String nom) {
        if (nom == null || nom.trim().isEmpty()) {
            log.warn("Nom du département invalide ou vide.");
            return List.of(); // Retourne une liste vide si le nom est invalide
        }
        List<Departement> departements = departementRepository.findByNameContainingIgnoreCase(nom);
        if (departements.isEmpty()) {
            log.info("Aucun département trouvé avec le nom : {}", nom);
        } else {
            log.info("{} département(s) trouvé(s) avec le nom : {}", departements.size(), nom);
        }
        return departements;
    }


}
