package tn.esprit.examen.nomPrenomClasseExamen.entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Setter
@Getter
@Entity
public class Departement implements Serializable {

    private static final long serialVersionUID = -357738161698377833L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long   idDepartement;
    private String name;

    public Departement() {
        super();
    }

    public Departement(String name) {
        this.name = name;
    }

    public Long getIdDepartement() {
        return idDepartement;
    }

    public String getName() {
        return name;
    }

    public void setIdDepartement(Long idDepartement) {
        this.idDepartement = idDepartement;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Departement (Long idDepartement, String name) {
        this.idDepartement = idDepartement;
        this.name = name;
    }
}