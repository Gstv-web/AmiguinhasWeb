package br.com.amiguinhasWeb.App.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.amiguinhasWeb.App.Models.Cliente;
import br.com.amiguinhasWeb.App.Repositories.ClienteRepository;

@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {
    
    @Autowired
    private ClienteRepository repository;

    @GetMapping("all")
    public ResponseEntity<List<Cliente>> findAllClients () {   
        List<Cliente> list = repository.findAll();
        if(list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
    }

    @PostMapping("/newclient")
    public ResponseEntity<Cliente> newClient(@RequestBody Cliente newClient) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(newClient));
    }
}
