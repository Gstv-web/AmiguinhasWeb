package br.com.amiguinhasWeb.App.Models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "tb_viagens")
public class Viagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long idViagem;
	
	@NotBlank
	private String destino;
	
	@NotBlank
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataViagem;
	
	@NotBlank
	private int quantidadeMaxPessoas;

	@OneToMany(mappedBy = "fkViagem")
	private Set<Excursao> excursao;
	
	
	public long getIdViagem() {
		return idViagem;
	}
	public void setIdViagem(long idViagem) {
		this.idViagem = idViagem;
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
