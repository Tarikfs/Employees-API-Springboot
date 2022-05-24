package br.com.vertigo.exercicio.tsantos.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.vertigo.exercicio.tsantos.api.model.Employees;

@Repository
public interface EmployeesRepository extends JpaRepository<Employees, Long> {

    
}