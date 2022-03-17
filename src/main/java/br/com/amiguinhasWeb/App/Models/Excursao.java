package br.com.amiguinhasWeb.App.Models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_excursao")
public class Excursao {
    
    @EmbeddedId
    ExcursaoEmb idExcursao;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente fkCliente;
    
    @ManyToOne
    @JoinColumn(name = "id_viagem")
    private Viagem fkViagem;

    @NotNull
    private boolean primeiraParcela;

    @NotNull
    private boolean segundaParcela;

    private boolean terceiraParcela;



    public ExcursaoEmb getIdExcursao() {
        return this.idExcursao;
    }

    public void setIdExcursao(ExcursaoEmb idExcursao) {
        this.idExcursao = idExcursao;
    }

    public Cliente getFkCliente() {
        return this.fkCliente;
    }

    public void setFkCliente(Cliente fkCliente) {
        this.fkCliente = fkCliente;
    }

    public Viagem getFkViagem() {
        return this.fkViagem;
    }

    public void setFkViagem(Viagem fkViagem) {
        this.fkViagem = fkViagem;
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
