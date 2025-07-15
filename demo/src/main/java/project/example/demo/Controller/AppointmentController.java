package project.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.example.demo.Model.Appointment;
import project.example.demo.Response.Response;
import project.example.demo.Service.AppointmentService;

import java.util.List;

@CrossOrigin(origins ={
        "http://localhost:4200",
        "https://staging.example.com",
        "https://app.example.com"
},methods = {
        RequestMethod.DELETE,RequestMethod.GET,RequestMethod.OPTIONS,RequestMethod.PUT,RequestMethod.POST
})
@RestController
public class AppointmentController {
        @Autowired
        private AppointmentService appointmentService;

        @PostMapping("/ajouterAppointment")
        public Response ajouterAppointment(@RequestBody Appointment appointment) {
                return appointmentService.ajouterAppointment(appointment);
        }

        @GetMapping("/afficheAppointment")
        public List<Appointment> afficherAppointment() {
                return appointmentService.afficherAppointments();
        }

        @GetMapping("/afficheAppointmentavecdate/{id}")
        public Appointment afficherAppointmentAvecId(@PathVariable int id) {
                return appointmentService.afficherAppointmentAvecId(id);
        }

        @DeleteMapping("/supprimedoAppointment/{id}")
        public Response supprimerAppointment(@PathVariable int id) {
                return appointmentService.supprimerAppointment(id);
        }

        @PutMapping("/modifierappointment")
        public Response modifierDoctor(@RequestBody Appointment appointment) {
                return appointmentService.modifierAppointment(appointment);
        }
        @PostMapping("/request")
        public ResponseEntity<Appointment> requestAppointment(@RequestBody Appointment rendezVous) {
                return new ResponseEntity<>(appointmentService.requestAppointment(rendezVous), HttpStatus.CREATED);
        }

        @GetMapping("/requested")
        public List<Appointment> getRequestedAppointments() {
                return appointmentService.getRequestedAppointments();
        }

        @PostMapping("/accept/{id}")
        public ResponseEntity<Appointment> acceptAppointment(@PathVariable int id) {
                return new ResponseEntity<>(appointmentService.acceptAppointment(id), HttpStatus.OK);
        }

        @DeleteMapping("/complete/{id}")
        public ResponseEntity<Void> completeAppointment(@PathVariable int id) {
                appointmentService.completeAppointment(id);
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        }
