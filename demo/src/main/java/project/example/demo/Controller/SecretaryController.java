package project.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.example.demo.Model.Secretary;
import project.example.demo.Response.Response;
import project.example.demo.Service.SecretaryService;

import java.util.List;


@RestController
public class SecretaryController {
    @Autowired
    private SecretaryService secretaryService;

    @PostMapping("/ajouterSecretary")
    public Response ajouterSecretary(@RequestBody Secretary secretary) {
        return secretaryService.ajouterSecretary(secretary);
    }

    @GetMapping("/afficheSecretary")
    public List<Secretary> afficherSecretary() {
        return secretaryService.afficherSecretaries();
    }

    @GetMapping("/afficheSecretaryavecid/{id}")
    public Secretary afficherSecretaryAvecId(@PathVariable int id) {
        return secretaryService.afficherSecretaryAvecId(id);
    }

    @DeleteMapping("/supprimesecretary/{id}")
    public Response supprimerSecretary(@PathVariable int id) {
        return secretaryService.supprimerSecretary(id);
    }

    @PutMapping("/modifiersecretary")
    public Response modifierSecretary(@RequestBody Secretary secretary) {
        return secretaryService.modifierSecretary(secretary);
    }

}
