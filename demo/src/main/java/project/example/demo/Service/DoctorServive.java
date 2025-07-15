package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Model.Doctor;
import project.example.demo.Repository.DoctorRepository;
import project.example.demo.Response.Response;

import java.util.List;
import java.util.Optional;
@Service
public class DoctorServive {
    @Autowired
    private DoctorRepository doctorRepository;
    public Optional<Doctor> findDoctorByEmail(String email) {
        return doctorRepository.findDoctorByEmail(email);
    }

    public Optional<Doctor> save(Doctor doctor) {

        doctor.setRole("Doctor");
        return Optional.of(doctorRepository.save(doctor));
    }
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }
    public Optional<Doctor> findById(int id) {
        return doctorRepository.findById(id);
    }
    public Response ajouterDoctor(Doctor doctor) {
        Doctor s = findDoctorByEmail(doctor.getEmail()).orElse(null);
        if (s != null) {

            throw new IllegalStateException("Docteur déjà ajouté");
        }
        save(doctor);
        return new Response("Docteur ajouté avec succès");
    }

    public List<Doctor> afficherDoctors() {
        return findAll();
    }

    public Doctor afficherDoctorAvecId(int id) {
        return findById(id)
                .orElseThrow(() -> new IllegalStateException("Docteur avec id " + id + " inexistant"));

    }

    public Response supprimerDoctor(int id) {
        if (!doctorRepository.existsById(id)) {
            return new Response("Docteur inexistant");
        }
        doctorRepository.deleteById(id);
        return new Response("Docteur supprimé avec succès");
    }

    public Response modifierDoctor(Doctor doctor) {
        Doctor existings = findDoctorByEmail(doctor.getEmail())
                .orElseThrow(() -> new IllegalStateException("Patient inexistant"));
        Doctor secAvecEmail = findDoctorByEmail(doctor.getEmail()).orElse(null);

        if (secAvecEmail != null && secAvecEmail.getId() != existings.getId()) {
            throw new IllegalStateException("Email " + doctor.getEmail() + " existe déjà");
        }

        existings.setFirstname(doctor.getFirstname());
        existings.setLastname(doctor.getLastname());
        existings.setEmail(doctor.getEmail());
        existings.setNumber(doctor.getNumber());
        existings.setGender(doctor.getGender());
        existings.setPassword(doctor.getPassword());
        ((Doctor) existings).setDepartment(doctor.getDepartment());
        ((Doctor) existings).setSpeciality(doctor.getSpeciality());

        save(existings);
        return new Response("Docteur modifié avec succès");
    }

}
