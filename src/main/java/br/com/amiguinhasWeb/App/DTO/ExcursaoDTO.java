package br.com.amiguinhasWeb.App.DTO;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ExcursaoDTO {
    
    private long idExcursao;
    private boolean primeiraParcela;
    private boolean segundaParcela;
    private boolean terceiraParcela;
    
    @JsonIgnoreProperties("excursao")
    private ClienteDTO cliente;
    
    @JsonIgnoreProperties("excursao")
    private ViagemDTO viagem;

    // Cosntructors
    public ExcursaoDTO(long idExcursao, boolean primeiraParcela, boolean segundaParcela, boolean terceiraParcela, ClienteDTO cliente, ViagemDTO viagem) {
        this.idExcursao = idExcursao;
        this.primeiraParcela = primeiraParcela;
        this.segundaParcela = segundaParcela;
        this.terceiraParcela = terceiraParcela;
        this.cliente = cliente;
        this.viagem = viagem;
    }
    
    public ExcursaoDTO() {}

    //Getters & Setters

    public long getIdExcursao() {
        return this.idExcursao;
    }

    public void setIdExcursao(long idExcursao) {
        this.idExcursao = idExcursao;
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

    public ClienteDTO getCliente() {
        return this.cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public ViagemDTO getViagem() {
        return this.viagem;
    }

    public void setViagem(ViagemDTO viagem) {
        this.viagem = viagem;
    }
    

}
