package project.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.example.demo.Model.Secretary;

import java.util.List;
import java.util.Optional;
@Repository
public interface SecretaryRepository extends JpaRepository<Secretary,Integer> {
    Optional<Secretary> findSecretaryByEmail(String email);
    @Query(value = "SELECT * from secretary",nativeQuery = true)
    List<Secretary> getsecretary();
}
