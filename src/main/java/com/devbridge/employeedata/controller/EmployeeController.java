package com.devbridge.employeedata.controller;

import com.devbridge.employeedata.model.entity.Employee;
import com.devbridge.employeedata.model.repository.EmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository){
        this.employeeRepository = employeeRepository;
    }

    @GetMapping
    @CrossOrigin(origins = "http://localhost:3000")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return employeeRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    @PostMapping
    public ResponseEntity createEmployee(@RequestBody Employee employee) throws URISyntaxException {
        Employee savedEmployee = employeeRepository.save(employee);
        return ResponseEntity.created(new URI("/employees/" + savedEmployee.getId())).body(savedEmployee);
    }
}
