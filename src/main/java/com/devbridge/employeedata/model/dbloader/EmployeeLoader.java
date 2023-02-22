package com.devbridge.employeedata.model.dbloader;

import com.devbridge.employeedata.model.entity.Employee;
import com.devbridge.employeedata.model.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class EmployeeLoader implements CommandLineRunner {
    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        this.employeeRepository.save(new Employee("Vardenis Pavardenis", "email@email.com", "8-621-2247"));
    }
}
