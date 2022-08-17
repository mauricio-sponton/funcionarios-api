package br.com.funcionarios.api.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.funcionarios.domain.model.Funcionario;
import br.com.funcionarios.domain.repository.FuncionarioRepository;
import br.com.funcionarios.domain.service.FuncionarioService;

@RestController
@RequestMapping(value = "/funcionarios")
public class FuncionarioController {
	
	@Autowired
	private FuncionarioService funcionarioService;
	
	@Autowired
	private FuncionarioRepository funcionarioRepository;

	@GetMapping("/calcular-salario")
	public BigDecimal calcularSalario() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		LocalDate data = LocalDate.parse("2018-01-01");
		
		return funcionarioService.calcularSalario(funcionarios, data);
	}
	
	@GetMapping("/calcular-beneficio")
	public BigDecimal calcularBeneficio() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		LocalDate data = LocalDate.parse("2018-01-01");
		
		return funcionarioService.calcularBeneficios(funcionarios, data);
	}
	
	@GetMapping("/calcular-salario-beneficio")
	public BigDecimal calcularSalarioEBeneficio() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		LocalDate data = LocalDate.parse("2018-01-01");
		
		return funcionarioService.calcularSalarioEBeneficios(funcionarios, data);
	}
	
	@GetMapping("/calcular-maior-salario")
	public Funcionario calcularMaiorSalario() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		LocalDate data = LocalDate.parse("2018-01-01");
		
		return funcionarioService.maiorSalario(funcionarios, data);
	}
	
	@GetMapping("/calcular-maior-beneficio")
	public Funcionario calcularMaiorBeneficio() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		LocalDate data = LocalDate.parse("2018-01-01");
		
		return funcionarioService.maiorBeneficio(funcionarios, data);
	}
	
	@GetMapping("/maior-venda")
	public Funcionario maiorVenda() {
		List<Funcionario> funcionarios = funcionarioRepository.findAll();
		LocalDate data = LocalDate.parse("2022-02-01");
		
		return funcionarioService.maiorVenda(funcionarios, data);
	}
}
