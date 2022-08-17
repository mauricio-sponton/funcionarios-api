package br.com.funcionarios.domain.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Cargo extends AbstractEntity {

	@Enumerated(EnumType.STRING)
	private NomeCargo nome;

	private BigDecimal salario;

	private BigDecimal beneficio;

	public NomeCargo getNome() {
		return nome;
	}

	public void setNome(NomeCargo nome) {
		this.nome = nome;
	}

	public BigDecimal getSalario() {
		return salario;
	}

	public void setSalario(BigDecimal salario) {
		this.salario = salario;
	}

	public BigDecimal getBeneficio() {
		return beneficio;
	}

	public void setBeneficio(BigDecimal beneficio) {
		this.beneficio = beneficio;
	}

	public BigDecimal calcularBeneficio(Integer anosTrabalhados) {

		if (this.nome.equals(NomeCargo.SECRETARIO)) {
			return this.beneficio = calcularSalario(anosTrabalhados).multiply(new BigDecimal(0.2));
		}

		else if (this.nome.equals(NomeCargo.VENDEDOR)) {
			return this.beneficio = this.salario.multiply(new BigDecimal(0.2));
		}

		else {
			return this.beneficio = BigDecimal.ZERO;
		}

	}

	public BigDecimal calcularSalario(Integer anosTrabalhados) {

		if (this.nome.equals(NomeCargo.SECRETARIO)) {
			return this.salario = salario.add(BigDecimal.valueOf(anosTrabalhados).multiply(new BigDecimal(1000)));
		}

		else if (this.nome.equals(NomeCargo.VENDEDOR)) {
			return this.salario = salario.add(BigDecimal.valueOf(anosTrabalhados).multiply(new BigDecimal(1800)));
		} else {
			return this.salario = salario.add(BigDecimal.valueOf(anosTrabalhados).multiply(new BigDecimal(3000)));
		}
	}

	public BigDecimal calcularSalarioEBeneficio(Integer anosTrabalhados) {
		return calcularBeneficio(anosTrabalhados).add(this.salario);
	}

	public boolean recebeBeneficio() {
		return !this.nome.equals(NomeCargo.GERENTE) && this.salario.compareTo(BigDecimal.ZERO) > 0;
	}

}
