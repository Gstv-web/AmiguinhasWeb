package br.com.amiguinhasWeb.App.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_excursao")
public class Excursao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idExcursao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    Cliente cliente;
    
    @ManyToOne
    @JoinColumn(name = "id_viagem")
    Viagem viagem;

    @NotNull
    private boolean primeiraParcela;

    @NotNull
    private boolean segundaParcela;

    private boolean terceiraParcela;


    public long getIdExcursao() {
        return this.idExcursao;
    }

    public void setIdExcursao(long idExcursao) {
        this.idExcursao = idExcursao;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Viagem getViagem() {
        return this.viagem;
    }

    public void setViagem(Viagem viagem) {
        this.viagem = viagem;
    }

    public boolean isPrimeiraParcela() {
        return this.primeiraParcela;
    }

    public boolean getPrimeiraParcela() {
        return this.primeiraParcela;
    }

    public void setPrimeiraParcela(boolean primeiraParcela) {
        this.primeiraParcela = primeiraParcela;
    }

    public boolean isSegundaParcela() {
        return this.segundaParcela;
    }

    public boolean getSegundaParcela() {
        return this.segundaParcela;
    }

    public void setSegundaParcela(boolean segundaParcela) {
        this.segundaParcela = segundaParcela;
    }

    public boolean isTerceiraParcela() {
        return this.terceiraParcela;
    }

    public boolean getTerceiraParcela() {
        return this.terceiraParcela;
    }

    public void setTerceiraParcela(boolean terceiraParcela) {
        this.terceiraParcela = terceiraParcela;
    }

}
