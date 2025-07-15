package project.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.example.demo.Model.Appointment;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,Integer> {
    Optional<Appointment> findAppointmentByDate(Date date);
    List<Appointment> findAll();

    List<Appointment> findByStatut(String requested);
}
