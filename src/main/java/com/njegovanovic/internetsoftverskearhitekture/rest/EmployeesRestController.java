package com.njegovanovic.internetsoftverskearhitekture.rest;

import com.njegovanovic.internetsoftverskearhitekture.entity.Employees;
import com.njegovanovic.internetsoftverskearhitekture.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class EmployeesRestController {

    private EmployeesService employeesService;

    @Autowired
    public EmployeesRestController(EmployeesService theEmployeesService) {
        employeesService = theEmployeesService;
    }

    // expose "/employees" and return list of employees
    @GetMapping("/employees")
    public List<Employees> findAll() {
        return employeesService.findAll();
    }

    // add mapping for GET /employees/{employeeNumber}
    @GetMapping("/employees/{employeeNumber}")
    public Employees getEmployee(@PathVariable int employeeNumber) {
        Employees theEmployees = employeesService.findById(employeeNumber);

        if (theEmployees == null) {
            throw new RuntimeException("Employee ID not found - " + employeeNumber);
        }

        return theEmployees;
    }

    // add mapping for POST /employees - add new employee
    @PostMapping("/employees")
    public Employees addEmployee(@RequestBody Employees theEmployees) {
        // just in case they pass an id in JSON ... set id to 0
        // force a save of new item ... instead of update
        employeesService.save(theEmployees);
        return theEmployees;
    }

    // add mapping for PUT /employees - update existing employee
    @PutMapping("/employees")
    public Employees updateEmployee(@RequestBody Employees theEmployees) {
        employeesService.save(theEmployees);
        return theEmployees;
    }

    // add mapping for DELETE /employees/{employeeNumber}
    @DeleteMapping("/employees/{employeeNumber}")
    public void deleteEmployee(@PathVariable int employeeNumber) {
        Employees tempEmployees = employeesService.findById(employeeNumber);

        if (tempEmployees == null) {
            throw new RuntimeException("Employee ID is not found - " + employeeNumber);
        }

        employeesService.deleteById(employeeNumber);

        findAll();
    }
}
