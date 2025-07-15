package project.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.example.demo.Model.Doctor;
import project.example.demo.Response.Response;
import project.example.demo.Service.DoctorServive;

import java.util.List;


@RestController
public class DoctorController {
    @Autowired
    private DoctorServive doctorService;

    @PostMapping("/ajouterDoctor")
    public Response ajouterPatient(@RequestBody Doctor doctor) {
        return doctorService.ajouterDoctor(doctor);
    }

    @GetMapping("/afficheDoctor")
    public List<Doctor> afficherDoctors() {
        return doctorService.afficherDoctors();
    }

    @GetMapping("/afficheDoctoravecid/{id}")
    public Doctor afficherDoctorAvecId(@PathVariable int id) {
        return doctorService.afficherDoctorAvecId(id);
    }

    @DeleteMapping("/supprimedoctor/{id}")
    public Response supprimerDoctor(@PathVariable int id) {
        return doctorService.supprimerDoctor(id);
    }

    @PutMapping("/modifierdoctor")
    public Response modifierDoctor(@RequestBody Doctor doctor) {
        return doctorService.modifierDoctor(doctor);
    }
}
