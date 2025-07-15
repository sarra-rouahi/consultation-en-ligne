package project.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.example.demo.Model.Doctor;
import project.example.demo.Model.Prescription;
import project.example.demo.Model.User;

import java.util.List;
import java.util.Optional;
@Repository
public interface PresRepository extends JpaRepository<Prescription,Integer> {
    Optional<Prescription> findPrescriptionById(Integer id);
    @Query(value = "SELECT * FROM `pres`", nativeQuery = true)
    List<Prescription> getprescreption();

}
