package br.com.funcionarios.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.funcionarios.domain.model.Cargo;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long>{

}
