package project.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.example.demo.Model.Patient;
import project.example.demo.Response.Response;
import project.example.demo.Service.PatientService;

import java.util.List;


@RestController
public class PatientController {
    @Autowired
    private PatientService patientService;

    @PostMapping("/ajouterPatient")
    public Response ajouterPatient(@RequestBody Patient patient) {
        return patientService.ajouterPatient(patient);
    }



    @GetMapping("/affichePatient")
    public List<Patient> afficherPatient() {
        return patientService.afficherPatients();
    }

    @GetMapping("/affichePatientavecid/{id}")
    public Patient afficherPatientAvecId(@PathVariable int id) {
        return patientService.afficherPatientAvecId(id);
    }

    @DeleteMapping("/supprimepatient/{id}")
    public Response supprimerPatient(@PathVariable int id) {
        return patientService.supprimerPatient(id);
    }

    @PutMapping("/modifierpatient")
    public Response modifierPatient(@RequestBody Patient patient) {
        return patientService.modifierPatient(patient);
    }
}
