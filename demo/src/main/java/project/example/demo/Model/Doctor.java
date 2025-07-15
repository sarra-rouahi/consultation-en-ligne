package project.example.demo.Model;

import jakarta.persistence.Entity;

@Entity
public class Doctor extends User{


    private String speciality;
    private String department;
   public  final String role ="doctor";

    public Doctor(String speciality, String department) {
        this.speciality = speciality;
        this.department = department;
    }

    public Doctor(int id, String firstname, String lastname, String email, String password, String number, String gender, String role, String speciality, String department) {
        super(id, firstname, lastname, email, password, number, gender, role);
        this.speciality = speciality;
        this.department = department;
    }

    public Doctor() {

    }

    public String getSpeciality() {
        return speciality;
    }

    public String getRole() {
        return role;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Doctor{" +

                "IdUser=" + getId() +
                ", Firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", gender='" + getGender() + '\'' +

                "speciality='" + speciality + '\'' +
                ", department='" + department + '\''  +
                ", role='" + role + '\'' +
                '}';
    }
}
