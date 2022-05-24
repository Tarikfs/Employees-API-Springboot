package br.com.vertigo.exercicio.tsantos.api.service;

public class EmployeeNotFoundException extends RuntimeException {

  public EmployeeNotFoundException() {
    super("Employee not found");
  }
}
