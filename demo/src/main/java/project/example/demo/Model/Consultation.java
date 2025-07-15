package project.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Consultation extends Appointment{

   private String notes;

    public Consultation(int idapp, int idpatient, int iddoctor, Date date, String statut, Integer id, String notes) {
        super(idapp, idpatient, iddoctor, date, statut);
        this.notes = notes;
    }



    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public Consultation(Integer id, String notes) {
        this.notes = notes;
    }

    public Consultation() {

    }
}
