package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Model.Secretary;
import project.example.demo.Model.User;
import project.example.demo.Repository.SecretaryRepository;
import project.example.demo.Response.Response;

import java.util.List;
import java.util.Optional;


@Service
public class SecretaryService {
    @Autowired
    private SecretaryRepository secretaryRepository;
    public Optional<Secretary> findSecretaryByEmail(String email) {
        return secretaryRepository.findSecretaryByEmail(email);
    }

    public Optional<User> save(Secretary secretary) {
        secretary.setRole("Secretary");
        return Optional.of(secretaryRepository.save(secretary));
    }
    public List<Secretary> findAll() {
        return secretaryRepository.findAll();
    }
    public Optional<Secretary> findById(int id) {
        return secretaryRepository.findById(id);
    }
    public Response ajouterSecretary(Secretary secretary) {
        Secretary s = findSecretaryByEmail(secretary.getEmail()).orElse(null);
        if (s != null) {

            throw new IllegalStateException("Secrétaire déjà ajouté");
        }
        save(secretary);
        return new Response("Secrétaire ajouté avec succès");
    }

    public List<Secretary> afficherSecretaries() {
            return findAll();
    }

    public Secretary afficherSecretaryAvecId(int id) {
        return findById(id)
                .orElseThrow(() -> new IllegalStateException("Secretaire avec id " + id + " inexistant"));

    }

    public Response supprimerSecretary(int id) {
        if (!secretaryRepository.existsById(id)) {
            return new Response("Secrétaire inexistant");
        }
        secretaryRepository.deleteById(id);
        return new Response("Secrétaire supprimé avec succès");
    }

    public Response modifierSecretary(Secretary secretary) {
        Secretary existings = findSecretaryByEmail(secretary.getEmail())
                .orElseThrow(() -> new IllegalStateException("Secrétaire inexistant"));
        Secretary secAvecEmail = findSecretaryByEmail(secretary.getEmail()).orElse(null);

        if (secAvecEmail != null && secAvecEmail.getId() != existings.getId()) {
            throw new IllegalStateException("Email " + secretary.getEmail() + " existe déjà");
        }

        existings.setFirstname(secretary.getFirstname());
        existings.setLastname(secretary.getLastname());
        existings.setEmail(secretary.getEmail());
        existings.setNumber(secretary.getNumber());
        existings.setGender(secretary.getGender());
        existings.setPassword(secretary.getPassword());
        ((Secretary) existings).setDepartment(secretary.getDepartment());

        save(existings);
        return new Response("Secrétaire modifié avec succès");
    }


}
