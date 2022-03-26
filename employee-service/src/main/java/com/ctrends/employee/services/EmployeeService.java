package com.ctrends.employee.services;

import com.ctrends.employee.models.Employee;
import com.ctrends.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Long empId, Employee employee){
        employee.setId(empId);
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Long empId){
        employeeRepository.deleteById(empId);
    }

    public Employee getEmployeeById(Long empId){
        return employeeRepository.findById(empId).get();
    }

    public Employee getEmployeeByEmail(String email){
        return employeeRepository.findByEmail(email);
    }

    public Optional<Employee> findByUsername(String username){
        return employeeRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username){
        return employeeRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email){
        return employeeRepository.existsByEmail(email);
    }

}
