package br.com.vertigo.exercicio.tsantos.api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import br.com.vertigo.exercicio.tsantos.api.model.Employees;
import br.com.vertigo.exercicio.tsantos.api.repository.EmployeesRepository;

@ExtendWith(SpringExtension.class)
public class EmployeeServiceTest {

    @InjectMocks
    private EmployeeService service;

    @Mock
    private EmployeesRepository repository;

    private Long existingId;
    private Long nonExistingId;
    private Employees employee;
    private List<Employees> listEmployees;

    @BeforeEach
    void setup() throws Exception {
        existingId = 1L;
        nonExistingId = 10000L;
        employee = new Employees();
        listEmployees = new ArrayList<>();

        when(repository.findAll()).thenReturn(listEmployees);
        when(repository.findById(existingId)).thenReturn(Optional.of(employee));
        when(repository.findById(nonExistingId)).thenReturn(Optional.empty());

        doNothing().when(repository).deleteById(existingId);
        doThrow(EmployeeNotFoundException.class).when(repository).deleteById(nonExistingId);

        when(repository.save(ArgumentMatchers.any())).thenReturn(employee);

    }

    @Test
    public void findAllEmployeesTest() {
        List<Employees> resposta = service.findAll();

        Assertions.assertNotNull(resposta);

    }

    @Test
    public void testaSeOEmployeeRecebidoEstaCorreto() {
        Employees expectedEmployee = new Employees();
        expectedEmployee.setEmployee_id(530L);
        expectedEmployee.setDepartment("Office");
        expectedEmployee.setEmail("tsantos@vertigo.com.br");
        expectedEmployee.setEmployee_type("Developer");
        expectedEmployee.setFirst_name("Tarik");
        expectedEmployee.setLast_name("Santos");
        expectedEmployee.setStart_date(Date.valueOf("2022-02-14"));
        expectedEmployee.setStatus("Active");
        expectedEmployee.setJob_title("Backend java Developer");
        when(repository.findById(530L)).thenReturn(Optional.of(expectedEmployee));
        Employees employee = service.findById(530L);
        assertEquals(expectedEmployee, employee);

    }
}
