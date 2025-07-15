package project.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.example.demo.Model.Prescription;
import project.example.demo.Model.Secretary;
import project.example.demo.Response.Response;
import project.example.demo.Service.PresService;
import project.example.demo.Service.SecretaryService;

import java.util.List;

@RestController
public class PresController {
    @Autowired
    private PresService presService;

    @PostMapping("/ajouterPres")
    public Response ajouterpres(@RequestBody Prescription prescription) {
        return presService.ajouterpres(prescription);
    }

    @GetMapping("/affichePres")
    public List<Prescription> afficherpres() {
        return presService.afficherprescreptions();
    }

    @GetMapping("/affichePresavecid/{id}")
    public Prescription afficherPresAvecId(@PathVariable int id) {
        return presService.afficherPressAvecId(id);
    }

    @DeleteMapping("/supprimePres/{id}")
    public Response supprimerPres(@PathVariable int id) {
        return presService.supprimerPres(id);
    }

    @PutMapping("/modifierPres")
    public Response modifierPres(@RequestBody Prescription prescription) {
        return presService.modifierPres(prescription);
    }
}
