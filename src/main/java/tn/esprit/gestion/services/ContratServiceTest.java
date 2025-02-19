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

        // Mock the repository method for calculating total salary
        when(contratRepository.calculateTotalSalary()).thenReturn(5000.00);

        // Call the service method
        String result = contratService.calculateSalary(typeContrat, "total");

        // Verify the result
        assertEquals("Le salaire total de tous les types de contrats et références est de 5000.00", result);
    }

    @Test
    public void testCalculateAverageSalaryByType() {
        String typeContrat = "CDI";

        // Mock the repository method for calculating average salary by type
        when(contratRepository.calculateAverageSalaryByType(typeContrat)).thenReturn(3000.00);

        // Call the service method
        String result = contratService.calculateSalary(typeContrat, "average");

        // Verify the result
        assertEquals("Le salaire moyen pour le contrat de type CDI est de 3000.00", result);
    }

    @Test
    public void testAddContrat() {
        // Mock the repository to return the contrat we save
        when(contratRepository.save(contrat1)).thenReturn(contrat1);

        // Call the service method
        Contrat result = contratService.add(contrat1);

        // Verify the result
        assertNotNull(result);
        assertEquals(contrat1, result);
    }

    @Test
    public void testGetAllContrats() {
        // Mock the repository to return a list of contrats
        List<Contrat> contrats = Arrays.asList(contrat1, contrat2);
        when(contratRepository.findAll()).thenReturn(contrats);

        // Call the service method
        List<Contrat> result = contratService.getAll();

        // Verify the result
        assertNotNull(result);
        assertEquals(2, result.size());
    }

    @Test
    public void testFilterBySalaire() {
        // Mock the repository method for filtering contrats by salary
        when(contratRepository.findBySalaireGreaterThanEqual(2500)).thenReturn(Arrays.asList(contrat1));

        // Call the service method
        List<Contrat> result = contratService.filterBySalaire(2500);

        // Verify the result
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(contrat1, result.get(0));
    }
}
