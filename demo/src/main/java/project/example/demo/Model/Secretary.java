package project.example.demo.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Objects;
@Entity
@Table(schema = "secretary")
public class Secretary extends User {
    private String department;
    public final String role = "secretary";

    public Secretary(String department) {
        this.department = department;
    }

    public Secretary(int id, String firstname, String lastname, String email, String password, String number, String gender, String role, String department) {
        super(id, firstname, lastname, email, password, number, gender, role);
        this.department = department;
    }

    public Secretary() {

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Secretary secretary = (Secretary) o;
        return Objects.equals(department, secretary.department);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), department);
    }

    @Override
    public String toString() {
        return "Secretary{" +
                "IdUser=" + getId() +
                ", Firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", number='" + getNumber() + '\'' +
                ", gender='" + getGender() + '\'' +
                "department='" + department + '\''  +
                ", role='" + role + '\'' +
                '}';
    }
}
