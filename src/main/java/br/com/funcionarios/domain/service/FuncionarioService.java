package br.com.funcionarios.domain.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.funcionarios.domain.exception.FuncionarioNaoEncontradoException;
import br.com.funcionarios.domain.model.Funcionario;
import br.com.funcionarios.domain.model.Venda;
import br.com.funcionarios.domain.repository.FuncionarioRepository;
import br.com.funcionarios.domain.repository.VendaRepository;

@Service
public class FuncionarioService {

	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private VendaRepository vendaRepository;

	public BigDecimal calcularSalario(List<Funcionario> funcionarios, LocalDate data) {

		BigDecimal total = BigDecimal.ZERO;

		for (Funcionario f : funcionarios) {

			Funcionario funcionario = buscarOuFalhar(f.getId());
			total = total.add(funcionario.getCargo().calcularSalario(f.anosTrabalhados(data)));

		}

		return total.setScale(2, RoundingMode.HALF_EVEN);

	}

	public BigDecimal calcularBeneficios(List<Funcionario> funcionarios, LocalDate data) {

		BigDecimal total = BigDecimal.ZERO;

		for (Funcionario f : funcionarios) {

			if (f.getCargo().recebeBeneficio()) {

				Funcionario funcionario = buscarOuFalhar(f.getId());
				total = total.add(funcionario.getCargo().calcularBeneficio(f.anosTrabalhados(data)));
			}

		}

		return total.setScale(2, RoundingMode.HALF_EVEN);

	}

	public BigDecimal calcularSalarioEBeneficios(List<Funcionario> funcionarios, LocalDate data) {

		BigDecimal total = BigDecimal.ZERO;

		for (Funcionario f : funcionarios) {

			Funcionario funcionario = buscarOuFalhar(f.getId());
			total = total.add(funcionario.getCargo().calcularSalarioEBeneficio(f.anosTrabalhados(data)));

		}

		return total.setScale(2, RoundingMode.HALF_EVEN);

	}

	public Funcionario maiorSalario(List<Funcionario> funcionarios, LocalDate data) {
		BigDecimal maiorSalario = BigDecimal.ZERO;
		HashMap<Funcionario, BigDecimal> map = new HashMap<>();

		for (Funcionario f : funcionarios) {

			Funcionario funcionario = buscarOuFalhar(f.getId());
			BigDecimal salarioCalculado = funcionario.getCargo().calcularSalario(f.anosTrabalhados(data));

			if (salarioCalculado.compareTo(maiorSalario) > 0) {
				maiorSalario = salarioCalculado;
				map.put(funcionario, maiorSalario);
			}

		}

		BigDecimal maxValueInMap = (Collections.max(map.values()));

		for (Entry<Funcionario, BigDecimal> entry : map.entrySet()) {
			if (entry.getValue().equals(maxValueInMap)) {
				return entry.getKey();
			}
		}

		return null;
	}

	public Funcionario maiorBeneficio(List<Funcionario> funcionarios, LocalDate data) {

		BigDecimal maiorBeneficio = BigDecimal.ZERO;
		HashMap<Funcionario, BigDecimal> map = new HashMap<>();

		for (Funcionario f : funcionarios) {
			if (f.getCargo().recebeBeneficio()) {
				Funcionario funcionario = buscarOuFalhar(f.getId());
				BigDecimal beneficioCalculado = funcionario.getCargo().calcularBeneficio(f.anosTrabalhados(data));

				if (beneficioCalculado.compareTo(maiorBeneficio) > 0) {
					maiorBeneficio = beneficioCalculado;
					map.put(funcionario, maiorBeneficio);
				}
			}

		}

		BigDecimal maxValueInMap = (Collections.max(map.values()));

		for (Entry<Funcionario, BigDecimal> entry : map.entrySet()) {
			if (entry.getValue().equals(maxValueInMap)) {
				return entry.getKey();
			}
		}

		return null;

	}

	public Funcionario maiorVenda(List<Funcionario> funcionarios, LocalDate data) {
		BigDecimal maior = BigDecimal.ZERO;
		int ano = data.getYear();
		int mes = data.getMonthValue();

		HashMap<Funcionario, BigDecimal> map = new HashMap<>();

		List<Venda> vendas = vendaRepository.maiorVenda(ano, mes);

		for (Venda v : vendas) {

			Funcionario funcionario = buscarOuFalhar(v.getVendedor().getId());

			if (v.getValor().compareTo(maior) > 0) {
				maior = v.getValor();
				map.put(funcionario, maior);
			}
		}

		BigDecimal maxValueInMap = (Collections.max(map.values()));

		for (Entry<Funcionario, BigDecimal> entry : map.entrySet()) {
			if (entry.getValue().equals(maxValueInMap)) {
				return entry.getKey();
			}
		}

		return null;
	}

	public Funcionario buscarOuFalhar(Long funcionarioId) {
		return funcionarioRepository.findById(funcionarioId)
				.orElseThrow(() -> new FuncionarioNaoEncontradoException(funcionarioId));
	}

}
