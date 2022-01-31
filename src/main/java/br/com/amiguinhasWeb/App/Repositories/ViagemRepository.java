package br.com.amiguinhasWeb.App.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.amiguinhasWeb.App.Models.Viagem;

@Repository
public interface ViagemRepository extends JpaRepository<Viagem, Long> {
    
}
