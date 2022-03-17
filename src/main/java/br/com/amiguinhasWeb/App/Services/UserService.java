package br.com.amiguinhasWeb.App.Services;

import java.nio.charset.Charset;
import java.util.Optional;

import javax.validation.Valid;


import org.apache.commons.codec.binary.Base64;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.amiguinhasWeb.App.DTO.CredentialsDTO;
import br.com.amiguinhasWeb.App.DTO.UserLoginDTO;
import br.com.amiguinhasWeb.App.Models.User;
import br.com.amiguinhasWeb.App.Repositories.UserRepository;

@Service
public class UserService {

    private CredentialsDTO credentialsDTO;

    @Autowired
    private UserRepository repo;

    @Autowired
    private ModelMapper mapper;

    //Criptografar senha
    private static String encrypt(String encrypt) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(encrypt);
    }
    
    // Gerador de token basic 
    private static String basicTokenGenerator(String email, String senha) {
        String auth = email + ":" + senha;
        byte[] authBase64 = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
        return "Basic " + new String(authBase64);
    }

    // Cadastrar um usuário caso não conste no banco de dados
    public ResponseEntity<User> signUser(User newUser) {
        Optional<User> optional = repo.findByEmail(newUser.getEmail());

        if (optional.isPresent()) {
            newUser.setSenha(encrypt(newUser.getSenha()));
            return ResponseEntity.status(HttpStatus.CREATED).body(repo.save(newUser));
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "ERRO: Usuário já existe!");
        }
    }

    // Valida o email e senha para login
    public ResponseEntity<CredentialsDTO> login(@Valid UserLoginDTO dto) {
        return repo.findByEmail(dto.getEmail()).map(resp -> {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            if (encoder.matches(dto.getSenha(), resp.getSenha())) {
                credentialsDTO = new CredentialsDTO(
                            resp.getUserId(),
                            basicTokenGenerator(dto.getEmail(), dto.getSenha()),
                            resp.getEmail());
                return ResponseEntity.status(HttpStatus.OK).body(credentialsDTO);
            } else {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Senha inválida");
            }
        }).orElseThrow(() -> {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuário não existe.");
        });
    }

}
