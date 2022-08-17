package br.com.funcionarios.domain.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Funcionario extends AbstractEntity {

	@NotBlank
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false, columnDefinition = "date")
	private LocalDate contratacao;

	@ManyToOne
	@JoinColumn(nullable = false)
	private Cargo cargo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getContratacao() {
		return contratacao;
	}

	public void setContratacao(LocalDate contratacao) {
		this.contratacao = contratacao;
	}

	public Cargo getCargo() {
		return cargo;
	}

	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}

	public Integer anosTrabalhados(LocalDate data) {
		return data.getYear() - this.contratacao.getYear();
	}

}
