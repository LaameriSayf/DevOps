package tn.esprit.gestion.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import tn.esprit.gestion.entities.Contrat;

import java.util.List;

public interface IContratRepository extends JpaRepository<Contrat, Long> {
    List<Contrat> findBySalaireGreaterThanEqual(float salaire);
    @Query("SELECT SUM(c.salaire) FROM Contrat c")
    double calculateTotalSalary();

    @Query("SELECT AVG(c.salaire) FROM Contrat c WHERE c.typeContrat = :typeContrat")
    double calculateAverageSalaryByType(@Param("typeContrat") String typeContrat);


}
