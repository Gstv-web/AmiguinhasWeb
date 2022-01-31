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

import br.com.amiguinhasWeb.App.Models.Viagem;
import br.com.amiguinhasWeb.App.Repositories.ViagemRepository;

@RestController
@RequestMapping("/viagem")
@CrossOrigin
public class ViagemController {
    
    @Autowired
    private ViagemRepository repository;

    @GetMapping("/all")
    public ResponseEntity<List<Viagem>> getAllViagem() {
        List<Viagem> list = repository.findAll();
        if (list.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(list);
        }
    }

    @PostMapping("/newviagem")
    public ResponseEntity<Viagem> newViagem(@RequestBody Viagem newViagem) {
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(newViagem));
    }
}
