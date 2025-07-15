package project.example.demo.Model;

import jakarta.persistence.*;

import java.util.Objects;
@Entity
@Table(schema = "User")
public class User {
    @Id
    @GeneratedValue
    private int Id;
    private String Firstname;
    private String lastname;

    public User() {
    }
@Column(name="email",unique = true)
    private String email;
    private String password;
    private String number;
    private String gender;
    private  String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(int id, String firstname, String lastname, String email, String password, String number, String gender, String role) {
        Id = id;
        Firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.number = number;
        this.gender = gender;
        this.role = role;
    }

    public int getId() {
        return Id;
    }

    public void setId(int idUser) {
        Id = idUser;
    }

    public String getFirstname() {
        return Firstname;
    }

    public void setFirstname(String firstname) {
        Firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Id == user.Id && Objects.equals(Firstname, user.Firstname) && Objects.equals(lastname, user.lastname) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && Objects.equals(number, user.number) && Objects.equals(gender, user.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Id, Firstname, lastname, email, password, number, gender);
    }

    @Override
    public String toString() {
        return "User{" +
                "IdUser=" + Id +
                ", Firstname='" + Firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", number='" + number + '\'' +
                ", gender='" + gender + '\'' +
                '}';
    }
}