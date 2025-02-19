package tn.esprit.gestion.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.gestion.entities.Contrat;
import tn.esprit.gestion.repositories.IContratRepository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class ContratImpl implements IContrat {

    private final IContratRepository contratRepository;

    @Override
    public Contrat add(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat update(Contrat contrat) {
        return contratRepository.save(contrat);
    }

    @Override
    public void delete(Long id) {
        contratRepository.deleteById(id);
    }

    @Override
    public Contrat getById(Long id) {
        return contratRepository.findById(id).orElseThrow(() -> new RuntimeException("Contrat not found"));
    }

    @Override
    public List<Contrat> getAll() {
        return contratRepository.findAll();
    }

    @Override
    public List<Contrat> filterBySalaire(float minSalaire) {
        return contratRepository.findBySalaireGreaterThanEqual(minSalaire);
    }
    @Override
    public String calculateSalary(String typeContrat, String mode) {
        double totalSalary;
        String message;

        if ("average".equalsIgnoreCase(mode) && typeContrat != null) {
            totalSalary = contratRepository.calculateAverageSalaryByType(typeContrat);
            message = String.format("Le salaire moyen pour le contrat de type %s est de %.2f", typeContrat, totalSalary);
        } else {
            totalSalary = contratRepository.calculateTotalSalary();
            message = String.format("Le salaire total de tous les types de contrats et références est de %.2f", totalSalary);
        }

        return message;
    }




    @Override
    public void test() {
        log.info("Scheduled task is running every 15 seconds.");
    }
}
