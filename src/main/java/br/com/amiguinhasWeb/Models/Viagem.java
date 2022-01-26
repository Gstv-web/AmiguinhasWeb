package br.com.amiguinhasWeb.App.Models;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "tb_viagens")
public class Viagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String destino;
	
	@NotBlank
	private Date dataViagem;
	
	@NotBlank
	private int quantidadeMaxPessoas;
	
	@OneToMany(mappedBy = "viagem", cascade = CascadeType.ALL)
	@JsonIgnoreProperties("viagem")
	private List<Cliente> cliente;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Date getDataViagem() {
		return dataViagem;
	}
	public void setDataViagem(Date dataViagem) {
		this.dataViagem = dataViagem;
	}
	public int getQuantidadeMaxPessoas() {
		return quantidadeMaxPessoas;
	}
	public void setQuantidadeMaxPessoas(int quantidadeMaxPessoas) {
		this.quantidadeMaxPessoas = quantidadeMaxPessoas;
	}
	
	
	
}
