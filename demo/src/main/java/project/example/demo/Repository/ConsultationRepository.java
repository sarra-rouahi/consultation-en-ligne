package project.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.example.demo.Model.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation,Integer> {
}
