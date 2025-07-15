package project.example.demo.Model;



import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;
@Entity
public class Patient extends User {
    private Date birthdayDate;
    private String address;
public  final String role ="patient";

    public Patient(Date birthdayDate, String address) {
        this.birthdayDate = birthdayDate;
        this.address = address;
    }

    public Patient(int id, String firstname, String lastname, String email, String password, String number, String gender, String role, Date birthdayDate, String address) {
        super(id, firstname, lastname, email, password, number, gender, role);
        this.birthdayDate = birthdayDate;
        this.address = address;
    }

    public Patient() {
    }

    public Date getBirthdayDate() {
        return birthdayDate;
    }

    public void setBirthdayDate(Date birthdayDate) {
        this.birthdayDate = birthdayDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "IdUser=" + getId() +
                ", Firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", gender='" + getGender() + '\'' +
                "birthdayDate=" + birthdayDate +
                ", address='" + address + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
