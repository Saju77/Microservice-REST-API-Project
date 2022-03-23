package com.ctrends.employee.service;

import com.ctrends.employee.model.Employee;
import com.ctrends.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee saveEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Long empId, Employee employee){
        employee.setEmpId(empId);
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

}
