package com.ctrends.employee.controller;

import com.ctrends.employee.model.Employee;
import com.ctrends.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees(){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.saveEmployee(employee);
    }

    @PutMapping("/{empId}")
    public Employee updateEmployee(@PathVariable("empId") Long empId, @RequestBody Employee employee){
        return employeeService.updateEmployee(empId, employee);
    }

    @DeleteMapping("/{empId}")
    public void deleteEmployee(@PathVariable("empId") Long empId){
        employeeService.deleteEmployee(empId);
    }

    @GetMapping("/{empId}")
    public Employee getEmployeeById(@PathVariable("empId") Long empId){
        return employeeService.getEmployeeById(empId);
    }

    @GetMapping("/email/{email}")
    public Employee getEmployeeByEmail(@PathVariable("email") String email){
        return employeeService.getEmployeeByEmail(email);
    }

}
