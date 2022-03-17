package br.com.amiguinhasWeb.App.DTO;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ViagemDTO {
    
    private long idViagem;
    private String destino;
    private Date dataViagem;
    private int quantidadeMaxPessoas;

    @JsonIgnoreProperties("fkViagem")
    private Set<ExcursaoDTO> excursao;

    // Constructors

    public ViagemDTO(long idViagem, String destino, Date dataViagem, int quantidadeMaxPessoas, Set<ExcursaoDTO> excursao) {
        this.idViagem = idViagem;
        this.destino = destino;
        this.dataViagem = dataViagem;
        this.quantidadeMaxPessoas = quantidadeMaxPessoas;
        this.excursao = excursao;
    }

    public ViagemDTO() {}

    // Getters & Setters
    public long getIdViagem() {
        return this.idViagem;
    }

    public void setIdViagem(long idViagem) {
        this.idViagem = idViagem;
    }

    public String getDestino() {
        return this.destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getDataViagem() {
        return this.dataViagem;
    }

    public void setDataViagem(Date dataViagem) {
        this.dataViagem = dataViagem;
    }

    public int getQuantidadeMaxPessoas() {
        return this.quantidadeMaxPessoas;
    }

    public void setQuantidadeMaxPessoas(int quantidadeMaxPessoas) {
        this.quantidadeMaxPessoas = quantidadeMaxPessoas;
    }

    public Set<ExcursaoDTO> getExcursao() {
        return this.excursao;
    }

    public void setExcursao(Set<ExcursaoDTO> excursao) {
        this.excursao = excursao;
    }
    
}
