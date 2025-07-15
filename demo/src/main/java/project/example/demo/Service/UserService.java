package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import project.example.demo.Model.RegisterRequest;
import project.example.demo.Model.User;
import project.example.demo.Repository.UserRepository;
import project.example.demo.Response.Response;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public Optional<User> save(User user) {
        return Optional.of(userRepository.save(user));
    }

    public Optional<User> findById(int id) {
        return userRepository.findById(id);
    }
    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Response ajouterUser(User user) {
        User u = findUserByEmail(user.getEmail()).orElse(null);
        if (u != null) {
            throw new IllegalStateException("Utilisateur avec email " + user.getEmail() + " existe déjà");
        }

        save(user);
        return new Response("Utilisateur ajouté avec succès");
    }

    public List<User> afficherUsers() {
        return findAll();
    }

    public User afficherUserAvecId(int id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new IllegalStateException("Utilisateur avec id " + id + " inexistant"));
    }

    public Response supprimerUser(int id) {
        if (!userRepository.existsById(id)) {
            return new Response("Utilisateur avec id " + id + " inexistant");
        }

        userRepository.deleteById(id);
        return new Response("Utilisateur supprimé avec succès");
    }

    public Response modifierUser(User user) {
        User existingUser = findById(user.getId()).orElse(null);
        if (existingUser == null) {
            throw new IllegalStateException("Utilisateur avec id " + user.getId() + " inexistant");
        }

        User userAvecEmail = findUserByEmail(user.getEmail()).orElse(null);
        if (userAvecEmail != null && userAvecEmail.getId() != existingUser.getId()) {
            throw new IllegalStateException("Email " + user.getEmail() + " existe déjà");
        }

        existingUser.setFirstname(user.getFirstname());
        existingUser.setLastname(user.getLastname());
        existingUser.setEmail(user.getEmail());
        existingUser.setNumber(user.getNumber());
        existingUser.setGender(user.getGender());
        existingUser.setPassword(user.getPassword());

        userRepository.save(existingUser);
        return new Response("Utilisateur modifié avec succès");
    }

    public ResponseEntity<String> signin(RegisterRequest request) {
        // Here you would implement your authentication logic
        // For demonstration purposes, let's assume you have a UserRepository to check user credentials

        // First, retrieve the user by email from the repository
        Optional<User> userOptional = userRepository.findUserByEmail(request.getEmail());

        // Check if the user exists and if the provided password matches the stored password
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user.getPassword().equals(request.getPassword())) {
                // Authentication successful
                // You can return a token or any other authentication-related information
                return ResponseEntity.ok().body("{\"message\": \"Authentication successful!\",\"role\": \""+user.getRole()+"\"}");
            }
        }

        // Authentication failed
        // You can throw an exception or return an error message
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\": \"Authentication failed. Invalid email or password.\"}");
    }
}
