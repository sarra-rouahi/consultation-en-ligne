package project.example.demo.Controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.example.demo.Model.RegisterRequest;
import project.example.demo.Model.User;
import project.example.demo.Response.Response;
import project.example.demo.Service.UserService;

import java.util.List;


@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/ajouterUser")
    public Response ajouterUser(@RequestBody User user) {
        return userService.ajouterUser(user);
    }

    @GetMapping("/afficheUser")
    public List<User> afficherUsers() {
        return userService.afficherUsers();
    }

    @GetMapping("/afficheUseravecid/{id}")
    public User afficherUserAvecId(@PathVariable int id) {
        return userService.afficherUserAvecId(id);
    }

    @DeleteMapping("/supprimeuser/{id}")
    public Response supprimerUser(@PathVariable int id) {
        return userService.supprimerUser(id);
    }

    @PutMapping("/modifier")
    public Response modifierUser(@RequestBody User user) {
        return userService.modifierUser(user);
    }

    @PostMapping("/signin")
    public ResponseEntity<String> signin(@RequestBody RegisterRequest request) {
        return userService.signin(request);
    }

}
