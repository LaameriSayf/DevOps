package tn.esprit.gestion.services;

import tn.esprit.gestion.entities.Contrat;

import java.util.List;

public interface IContrat {
    Contrat add(Contrat contrat);
    Contrat update(Contrat contrat);
    void delete(Long id);
    Contrat getById(Long id);
    List<Contrat> getAll();
    List<Contrat> filterBySalaire(float minSalaire);
    String calculateSalary(String typeContrat, String mode);

    void test();
}
