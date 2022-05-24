package br.com.vertigo.exercicio.tsantos.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.vertigo.exercicio.tsantos.api.service.EmployeeService;

@SpringBootTest
class ApiApplicationTests {

	@Autowired
	EmployeeService employeeService;

	@Test
	void contextLoads() {
	}

}
