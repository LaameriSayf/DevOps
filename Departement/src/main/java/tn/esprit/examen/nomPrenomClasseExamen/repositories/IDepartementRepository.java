package tn.esprit.examen.nomPrenomClasseExamen.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.examen.nomPrenomClasseExamen.entities.Departement;

import java.util.List;

public interface IDepartementRepository extends JpaRepository<Departement, Integer> {
    List<Departement> findByNameContainingIgnoreCase(String name);
}
