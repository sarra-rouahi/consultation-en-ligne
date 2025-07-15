package project.example.demo.Model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(schema = "appointmentId_p")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idapp;
    private int idpatient;
    private int iddoctor;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    private String statut;

    // Default constructor
    public Appointment() {
    }

    public Appointment(int idapp, int idpatient, int iddoctor, Date date, String statut) {
    }

    public int getIdapp() {
        return idapp;
    }

    public void setIdapp(int idapp) {
        this.idapp = idapp;
    }

    public int getIdpatient() {
        return idpatient;
    }

    public void setIdpatient(int idpatient) {
        this.idpatient = idpatient;
    }

    public int getIddoctor() {
        return iddoctor;
    }

    public void setIddoctor(int iddoctor) {
        this.iddoctor = iddoctor;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "idapp=" + idapp +
                ", idpatient=" + idpatient +
                ", iddoctor=" + iddoctor +
                ", date=" + date +
                ", statut='" + statut + '\'' +
                '}';
    }
}
