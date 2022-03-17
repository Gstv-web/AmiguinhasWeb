package br.com.amiguinhasWeb.App.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.amiguinhasWeb.App.Models.Excursao;

@Repository
public interface ExcursaoRepository extends JpaRepository <Excursao, Long> {
    
    
}
// VER ISSO AQUI QUE TÁ ERRRADO