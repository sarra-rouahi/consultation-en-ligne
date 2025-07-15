package project.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.example.demo.Model.Appointment;
import project.example.demo.Repository.AppointmentRepository;
import project.example.demo.Response.Response;

import java.util.Date;
import java.util.List;
import java.util.Optional;
@Service
public class AppointmentService {
    @Autowired
    private AppointmentRepository appointmentRepository;
    public Optional<Appointment> findAppointmentByDate(Date date) {
        return appointmentRepository.findAppointmentByDate(date);
    }

    public Optional<Appointment> save(Appointment app) {
        return Optional.of(appointmentRepository.save(app));
    }
    public List<Appointment> findAll() {
        return appointmentRepository.findAll();
    }
    public Optional<Appointment> findById(int id) {
        return appointmentRepository.findById(id);
    }
    public Response ajouterAppointment(Appointment app) {
        Appointment s = findAppointmentByDate(app.getDate()).orElse(null);
        if (s != null) {

            throw new IllegalStateException("Rendez-vous déjà ajouté");
        }
        save(app);
        app.setStatut("Requested");
        return new Response("Rendez-vous ajouté avec succès");

    }

    public List<Appointment> afficherAppointments() {
        return findAll();
    }

    public Appointment afficherAppointmentAvecId(int id) {
        return findById(id)
                .orElseThrow(() -> new IllegalStateException("Rendez-vous avec id " + id + " inexistant"));

    }

    public Response supprimerAppointment(int id) {
        if (!appointmentRepository.existsById(id)) {
            return new Response("Rendez-vous inexistant");
        }
        appointmentRepository.deleteById(id);
        return new Response("Rendez-vous supprimé avec succès");
    }

    public Response modifierAppointment(Appointment appointment) {
        Appointment existings = findAppointmentByDate(appointment.getDate())
                .orElseThrow(() -> new IllegalStateException("Rendez-vous inexistant"));
        Appointment secAvecDate = findAppointmentByDate(appointment.getDate()).orElse(null);

        if (secAvecDate != null && secAvecDate.getDate() != existings.getDate()) {
            throw new IllegalStateException("Rendez-vous " + appointment.getDate() + " existe déjà");
        }

        existings.setIdpatient(appointment.getIdpatient());
        existings.setIddoctor(appointment.getIddoctor());
        existings.setIdapp(appointment.getIdapp());


        save(existings);
        return new Response("Rendez-vous modifié avec succès");
    }
    public Appointment requestAppointment(Appointment rendezVous) {
        rendezVous.setStatut("Requested");
        return appointmentRepository.save(rendezVous);
    }

    public List<Appointment> getRequestedAppointments() {
        return appointmentRepository.findByStatut("Requested");
    }

    public Appointment acceptAppointment(int id) {
        Appointment rendezVous = appointmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Rendez-vous non trouvé"));
        rendezVous.setStatut("Accepted");
        return appointmentRepository.save(rendezVous);
    }

    public void completeAppointment(int id) {
        appointmentRepository.deleteById(id);
    }
}
