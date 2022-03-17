package br.com.amiguinhasWeb.App.Models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExcursaoEmb implements Serializable {
    
    @Column(name = "fkCliente")
    private Long fkCliente;

    @Column(name = "fkViagem")
    private Long fkViagem;


    public Long getFkCliente() {
        return this.fkCliente;
    }

    public void setFkCliente(Long fkCliente) {
        this.fkCliente = fkCliente;
    }

    public Long getFkViagem() {
        return this.fkViagem;
    }

    public void setFkViagem(Long fkViagem) {
        this.fkViagem = fkViagem;
    }

}
