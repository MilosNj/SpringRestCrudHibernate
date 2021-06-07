package com.njegovanovic.internetsoftverskearhitekture.service;

import com.njegovanovic.internetsoftverskearhitekture.entity.Employees;

import java.util.List;

public interface EmployeesService {

    List<Employees> findAll();

    Employees findById(int theId);

    void save(Employees theEmployees);

    void deleteById(int theId);
}
