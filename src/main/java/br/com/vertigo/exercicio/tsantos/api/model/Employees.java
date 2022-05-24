package br.com.vertigo.exercicio.tsantos.api.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "employees")
public class Employees implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Positive
    private Long employee_id;

    @Size(min = 1, max = 45)
    private String first_name;
    @Size(min = 1, max = 45)
    private String last_name;
    @Size(min = 1, max = 45)
    private String department;
    @Size(min = 1, max = 45)
    private String job_title;
    @Size(min = 1, max = 45)
    private String employee_type;
    @Size(min = 1, max = 45)
    private String status;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date start_date;
    private String email;

    public Employees() {

    }

    public Employees(Long employee_id, @Size(min = 1, max = 45) String first_name,
            @Size(min = 1, max = 45) String last_name, @Size(min = 1, max = 45) String department,
            @Size(min = 1, max = 45) String job_title, @Size(min = 1, max = 45) String employee_type,
            @Size(min = 1, max = 45) String status, Date start_date, String email) {
        this.employee_id = employee_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.department = department;
        this.job_title = job_title;
        this.employee_type = employee_type;
        this.status = status;
        this.start_date = start_date;
        this.email = email;
    }

    public Long getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(Long employee_id) {
        this.employee_id = employee_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJob_title() {
        return job_title;
    }

    public void setJob_title(String job_title) {
        this.job_title = job_title;
    }

    public String getEmployee_type() {
        return employee_type;
    }

    public void setEmployee_type(String employee_type) {
        this.employee_type = employee_type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employees(Date start_date) {
        this.start_date = start_date;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
