package project.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(schema = "Pres")
public class Prescription {
    @Id
    @GeneratedValue
    private int Id;
    private int id_p;
    private int id_d;
    private String text;

    public Prescription(int id, int id_p, int id_d, String text) {
        Id = id;
        this.id_p = id_p;
        this.id_d = id_d;
        this.text = text;
    }

    public Prescription() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public int getId_p() {
        return id_p;
    }

    public void setId_p(int id_p) {
        this.id_p = id_p;
    }

    public int getId_d() {
        return id_d;
    }

    public void setId_d(int id_d) {
        this.id_d = id_d;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
