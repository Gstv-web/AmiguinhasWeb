package br.com.amiguinhasWeb.App.Models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name = "tb_cliente")
public class Cliente {
    
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idCliente;
	
	@NotBlank
	@Size(min = 3)
	private String nome;
	
	@NotNull
	private String documento;
	
	@NotNull
	private String orgEmissor;
	
	@NotBlank
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataCadastro = new java.sql.Date(System.currentTimeMillis());
	
	@OneToMany(mappedBy = "cliente")
	Set<Excursao> parcelas;


	public long getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(long idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getOrgEmissor() {
		return orgEmissor;
	}

	public void setOrgEmissor(String orgEmissor) {
		this.orgEmissor = orgEmissor;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

}