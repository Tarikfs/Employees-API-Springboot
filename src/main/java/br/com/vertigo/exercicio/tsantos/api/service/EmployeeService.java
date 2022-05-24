package br.com.vertigo.exercicio.tsantos.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.vertigo.exercicio.tsantos.api.model.Employees;
import br.com.vertigo.exercicio.tsantos.api.repository.EmployeesRepository;

@Service
public class EmployeeService {

  @Autowired
  private EmployeesRepository employeesRepository;

  public List<Employees> findAll() {
    return employeesRepository.findAll();
  }

  public Employees findById(Long id) {
    return employeesRepository
        .findById(id)
        .orElseThrow(() -> new EmployeeNotFoundException());
  }

  public void deleteById(Long id) {
    if (employeesRepository.existsById(id)) {
      employeesRepository.deleteById(id);
    } else {
      throw new EmployeeNotFoundException();
    }
  }

  public Employees postEmployee(Employees employees) {
    return employeesRepository.save(employees);
  }

  public Employees updateEmployee(Long id, Employees reqEmployees) {
    Employees employee = employeesRepository.getById(id);
    if (employeesRepository.existsById(id)) {
      employee.setFirst_name(reqEmployees.getFirst_name());
      employee.setLast_name(reqEmployees.getLast_name());
      employee.setDepartment(reqEmployees.getDepartment());
      employee.setJob_title(reqEmployees.getJob_title());
      employee.setEmployee_type(reqEmployees.getEmployee_type());
      employee.setStatus(reqEmployees.getStatus());
      employee.setStart_date(reqEmployees.getStart_date());
      employee.setEmail(reqEmployees.getEmail());
      return employeesRepository.save(employee);
    } else {
      throw new EmployeeNotFoundException();
    }
  }

  public Employees patchEmployee(Long id, Employees patchEmployee) {
    Employees employee = isHere(patchEmployee, findById(id));
    employee.setEmployee_id(id);
    postEmployee(employee);
    return employee;
  }

  private Employees isHere(Employees patchEmployee, Employees employee) {
    if (patchEmployee.getFirst_name() == null) {
      employee.setFirst_name(employee.getFirst_name());
    }

    if (patchEmployee.getLast_name() == null) {
      patchEmployee.setLast_name(employee.getLast_name());
    }

    if (patchEmployee.getDepartment() == null) {
      patchEmployee.setDepartment(employee.getDepartment());
    }

    if (patchEmployee.getJob_title() == null) {
      patchEmployee.setJob_title(employee.getDepartment());
    }

    if (patchEmployee.getEmployee_type() == null) {
      patchEmployee.setEmployee_type(employee.getEmployee_type());
    }

    if (patchEmployee.getStatus() == null) {
      patchEmployee.setStatus(employee.getStatus());
    }

    if (patchEmployee.getStart_date() == null) {
      patchEmployee.setStart_date(employee.getStart_date());
    }

    if (patchEmployee.getEmail() == null) {
      patchEmployee.setEmail(employee.getEmail());
    }
    return patchEmployee;
  }
}
