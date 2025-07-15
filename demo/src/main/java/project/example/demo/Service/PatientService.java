package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Model.Patient;
import project.example.demo.Repository.PatientRepository;
import project.example.demo.Response.Response;

import java.util.List;
import java.util.Optional;


    @Service
    public class PatientService {
        @Autowired
        private PatientRepository patientRepository;
        public Optional<Patient> findPatientByEmail(String email) {
            return patientRepository.findPatientByEmail(email);
        }

        public Optional<Patient> save(Patient patient) {
            patient.setRole("Patient");
            return Optional.of(patientRepository.save(patient));
        }
        public List<Patient> findAll() {
            return patientRepository.findAll();
        }
        public Optional<Patient> findById(int id) {
            return patientRepository.findById(id);
        }
        public Response ajouterPatient(Patient patient) {
            Patient s = findPatientByEmail(patient.getEmail()).orElse(null);
            if (s != null) {

                throw new IllegalStateException("Patient déjà ajouté");
            }
            save(patient);
            return new Response("Patient ajouté avec succès");
        }

        public List<Patient> afficherPatients() {
            return findAll();
        }

        public Patient afficherPatientAvecId(int id) {
            return findById(id)
                    .orElseThrow(() -> new IllegalStateException("Patient avec id " + id + " inexistant"));

        }

        public Response supprimerPatient(int id) {
            if (!patientRepository.existsById(id)) {
                return new Response("Patient inexistant");
            }
            patientRepository.deleteById(id);
            return new Response("Patient supprimé avec succès");
        }

        public Response modifierPatient(Patient patient) {
            Patient existings = findPatientByEmail(patient.getEmail())
                    .orElseThrow(() -> new IllegalStateException("Patient inexistant"));
            Patient secAvecEmail = findPatientByEmail(patient.getEmail()).orElse(null);

            if (secAvecEmail != null && secAvecEmail.getId() != existings.getId()) {
                throw new IllegalStateException("Email " + patient.getEmail() + " existe déjà");
            }

            existings.setFirstname(patient.getFirstname());
            existings.setLastname(patient.getLastname());
            existings.setEmail(patient.getEmail());
            existings.setNumber(patient.getNumber());
            existings.setGender(patient.getGender());
            existings.setPassword(patient.getPassword());


            save(existings);
            return new Response("Patient modifié avec succès");
        }


    }
