package br.com.amiguinhasWeb.App.Controllers;

import org.springframework.web.bind.annotation.RestController;

import br.com.amiguinhasWeb.App.Models.User;
import br.com.amiguinhasWeb.App.Models.UserLogin;
import br.com.amiguinhasWeb.App.Repositories.UserRepository;
import br.com.amiguinhasWeb.App.Services.UserService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;



@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<UserLogin> authentication(@RequestBody Optional<UserLogin> user) {
        return userService.login(user).map(resp -> ResponseEntity.ok(resp))
            .orElse(ResponseEntity.status(HttpStatus.UNAUTHORIZED).build());
    } 


    @PostMapping("/sign")
    public ResponseEntity<User> signIn(@RequestBody User newUser) {
        return userService.signUser(newUser).map(resp -> ResponseEntity.ok(resp))
            .orElse(ResponseEntity.status(HttpStatus.BAD_REQUEST).build());
    }
}
