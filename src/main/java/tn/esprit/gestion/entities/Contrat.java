package tn.esprit.gestion.entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class Contrat implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reference;

    @Temporal(TemporalType.DATE)
    private Date dateDebut;

    private String typeContrat;

    private float salaire;

    public Contrat() {
        super();
    }

    public Contrat(Date dateDebut, String typeContrat, float salaire) {
        this.dateDebut = dateDebut;
        this.typeContrat = typeContrat;
        this.salaire = salaire;
    }

    public Long getReference() {
        return reference;
    }

    public void setReference(Long reference) {
        this.reference = reference;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public String getTypeContrat() {
        return typeContrat;
    }

    public void setTypeContrat(String typeContrat) {
        this.typeContrat = typeContrat;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }
}
