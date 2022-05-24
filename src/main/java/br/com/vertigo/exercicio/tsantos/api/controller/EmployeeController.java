package br.com.vertigo.exercicio.tsantos.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.vertigo.exercicio.tsantos.api.model.Employees;
import br.com.vertigo.exercicio.tsantos.api.service.EmployeeService;

@RequestMapping(value = "/employee")
@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping(produces = "application/json")
    public List<Employees> lista() {
        return employeeService.findAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Employees> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok().body(employeeService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        employeeService.deleteById(id);
        return ResponseEntity.status(204).build();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Employees postEmployee(@RequestBody Employees  employees) {
        return employeeService.postEmployee(employees);
    }

    @PutMapping("/{id}")
    public Employees updateEmployee(@PathVariable Long id, @RequestBody Employees reqEmployees) {
        return employeeService.updateEmployee(id, reqEmployees);
    }

    @PatchMapping("/{id}")
    public Employees patchEmployee(@PathVariable Long id, @RequestBody Employees patchEmployee) {
        return employeeService.patchEmployee(id, patchEmployee);
    }

}
