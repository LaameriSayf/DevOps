package tn.esprit.gestion.services;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import tn.esprit.gestion.entities.Contrat;
import tn.esprit.gestion.repositories.IContratRepository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ContratServiceTest {

    @Mock
    private IContratRepository contratRepository;

    @InjectMocks
    private ContratImpl contratService;

    private Contrat contrat1;
    private Contrat contrat2;

    @BeforeEach
    public void setUp() throws ParseException {

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = dateFormat.parse("2025-02-01");
        Date date2 = dateFormat.parse("2025-02-01");

        contrat1 = new Contrat(date1, "CDI", 3000.00f);
        contrat2 = new Contrat(date2, "CDI", 2000.00f);
    }

    @Test
    public void testCalculateTotalSalaryByTypeAndDateRange() {
        String typeContrat = "CDI";
        String startDate = "2025-01-01";
        String endDate = "2025-12-31";

        when(contratRepository.calculateTotalSalary()).thenReturn(5000.00);

        String result = contratService.calculateSalary(typeContrat, "total");

        assertEquals("Le salaire total de tous les types de contrats et références est de 5000.00", result);
    }

    @Test
    public void testCalculateAverageSalaryByType() {
        String typeContrat = "CDI";

        when(contratRepository.calculateAverageSalaryByType(typeContrat)).thenReturn(3000.00);

        String result = contratService.calculateSalary(typeContrat, "average");

        assertEquals("Le salaire moyen pour le contrat de type CDI est de 3000.00", result);
    }

    @Test
    public void testAddContrat() {
        when(contratRepository.save(contrat1)).thenReturn(contrat1);

        Contrat result = contratService.add(contrat1);

        assertNotNull(result);
        assertEquals(contrat1, result);
    }

    @Test
    public void testGetAllContrats() {
        List<Contrat> contrats = Arrays.asList(contrat1, contrat2);
        when(contratRepository.findAll()).thenReturn(contrats);

        List<Contrat> result = contratService.getAll();

        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testFilterBySalaire() {
        when(contratRepository.findBySalaireGreaterThanEqual(2500)).thenReturn(Arrays.asList(contrat1));

        List<Contrat> result = contratService.filterBySalaire(2500);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(contrat1, result.get(0));
    }
}
