package br.com.amiguinhasWeb.App.Services;

import java.nio.charset.Charset;
import java.util.Optional;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import br.com.amiguinhasWeb.App.Models.User;
import br.com.amiguinhasWeb.App.Models.UserLogin;
import br.com.amiguinhasWeb.App.Repositories.UserRepository;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repository;

    public Optional<User> signUser(User user) {
        Optional<User> optional = repository.findByEmail(user.getEmail());
        if (optional.isPresent()) {
            return Optional.empty();
        }
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String senhaEncoder = encoder.encode(user.getSenha());
        user.setSenha(senhaEncoder);
        return Optional.ofNullable(repository.save(user));
    }

    public Optional<UserLogin> login (Optional<UserLogin> usuario) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        Optional<User> user = repository.findByEmail(usuario.get().getEmail());

        if (usuario.isPresent()) {
            if (encoder.matches(usuario.get().getSenha(), user.get().getSenha())) {
                String auth = usuario.get().getEmail() + ":" + user.get().getSenha();
                byte[] encodeAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("US-ASCII")));
                String authHeader = "Basic " + new String(encodeAuth);
                usuario.get().setToken(authHeader);
                usuario.get().setEmail(user.get().getEmail());
                return usuario;
            }    
        }
        return null;
    }
}
