package br.com.amiguinhasWeb.App.DTO;

import java.util.Date;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

public class ClienteDTO {
    
    private long idCliente;
    private String nome;
    private String documento;
    private String orgEmissor;
    private Date dataNascimento;
    private Date dataCadastro;

    @JsonIgnoreProperties("fkCliente")
    private Set<ExcursaoDTO> excursao;

    // Constructors
    public ClienteDTO(long idCliente, String nome, String documento, String orgEmissor, Date dataNascimento, Date dataCadastro, Set<ExcursaoDTO> excursao) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.documento = documento;
        this.orgEmissor = orgEmissor;
        this.dataNascimento = dataNascimento;
        this.dataCadastro = dataCadastro;
        this.excursao = excursao;
    }

    public ClienteDTO() {}
    
    // Getters & Setters
    public long getIdCliente() {
        return this.idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return this.documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getOrgEmissor() {
        return this.orgEmissor;
    }

    public void setOrgEmissor(String orgEmissor) {
        this.orgEmissor = orgEmissor;
    }

    public Date getDataNascimento() {
        return this.dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Date getDataCadastro() {
        return this.dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Set<ExcursaoDTO> getExcursao() {
        return this.excursao;
    }

    public void setExcursao(Set<ExcursaoDTO> excursao) {
        this.excursao = excursao;
    }

}
