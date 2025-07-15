package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Model.Prescription;
import project.example.demo.Model.Secretary;
import project.example.demo.Model.User;
import project.example.demo.Repository.PresRepository;
import project.example.demo.Repository.SecretaryRepository;
import project.example.demo.Response.Response;

import java.util.List;
import java.util.Optional;

@Service
public class PresService {
    @Autowired
    private PresRepository presRepository;
    public Optional<Prescription> findPresById(int id) {
        return presRepository.findPrescriptionById(id);
    }

    public Optional<Prescription> save(Prescription prescription) {

        return Optional.of(presRepository.save(prescription));
    }
    public List<Prescription> findAll() {
        return presRepository.findAll();
    }
    public Optional<Prescription> findById(int id) {
        return presRepository.findById(id);
    }
    public Response ajouterpres(Prescription prescription) {
        Prescription s = findPresById(prescription.getId()).orElse(null);
        if (s != null) {

            throw new IllegalStateException("Ordonance déjà ajouté");
        }
        save(prescription);
        return new Response("Ordonance ajouté avec succès");
    }

    public List<Prescription> afficherprescreptions() {
        return findAll();
    }

    public Prescription afficherPressAvecId(int id) {
        return findById(id)
                .orElseThrow(() -> new IllegalStateException("ordonnance avec id " + id + " inexistant"));

    }

    public Response supprimerPres(int id) {
        if (!presRepository.existsById(id)) {
            return new Response("Ordonance inexistant");
        }
        presRepository.deleteById(id);
        return new Response("Ordonance supprimé avec succès");
    }

    public Response modifierPres(Prescription prescription) {
        Prescription existings = findPresById(prescription.getId())
                .orElseThrow(() -> new IllegalStateException("Secrétaire inexistant"));
        Prescription secAvecEmail = findPresById(prescription.getId()).orElse(null);

        if (secAvecEmail != null && secAvecEmail.getId() != existings.getId()) {
            throw new IllegalStateException( " existe déjà");
        }

        existings.setId_d(prescription.getId_d());
        existings.setId_p(prescription.getId_p());
        existings.setText(prescription.getText());


        save(existings);
        return new Response("Ordonance modifié avec succès");
    }

}
