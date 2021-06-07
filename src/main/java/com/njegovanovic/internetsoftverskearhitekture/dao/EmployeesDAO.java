package com.njegovanovic.internetsoftverskearhitekture.dao;

import com.njegovanovic.internetsoftverskearhitekture.entity.Employees;

import java.util.List;

public interface EmployeesDAO {

    List<Employees> findAll();

    Employees findById(int theId);

    void save(Employees theEmployees);

    void deleteById(int theId);
}
