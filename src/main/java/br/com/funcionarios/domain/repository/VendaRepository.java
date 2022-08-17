package br.com.funcionarios.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.funcionarios.domain.model.Venda;

@Repository
public interface VendaRepository extends JpaRepository<Venda, Long>{

	@Query("select v from Venda v where month(v.data) = :mes and year(v.data) = :ano")
	List<Venda> maiorVenda(int ano, int mes);


}
