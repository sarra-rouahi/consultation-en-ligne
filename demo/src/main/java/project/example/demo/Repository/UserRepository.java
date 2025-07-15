package project.example.demo.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import project.example.demo.Model.User;

import java.util.List;
import java.util.Optional;
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
     Optional<User> findUserByEmail(String email);
    @Query(value = "SELECT * FROM `User`", nativeQuery = true)
     List<User> getuser();


    }


