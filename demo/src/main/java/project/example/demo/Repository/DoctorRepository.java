package project.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.example.demo.Model.Doctor;

import java.util.List;
import java.util.Optional;
@Repository
public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    Optional<Doctor> findDoctorByEmail(String email);
        @Query(value = "SELECT * from doctor",nativeQuery = true)
    List<Doctor> getdoctor();
}
