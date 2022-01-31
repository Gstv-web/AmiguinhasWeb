package br.com.amiguinhasWeb.App.Repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.amiguinhasWeb.App.Models.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
 
    public List<Cliente> findAllByNomeContainingIgnoreCase (String nome);
}
