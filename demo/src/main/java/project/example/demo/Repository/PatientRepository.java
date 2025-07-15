package project.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.example.demo.Model.Patient;

import java.util.List;
import java.util.Optional;
@Repository
public interface PatientRepository extends JpaRepository<Patient,Integer> {
    Optional<Patient> findPatientByEmail(String email);
    @Query(value = "SELECT * from user",nativeQuery = true)
    List<Patient> getpatient();
}
