package com.njegovanovic.internetsoftverskearhitekture.service;

import com.njegovanovic.internetsoftverskearhitekture.dao.EmployeesDAO;
import com.njegovanovic.internetsoftverskearhitekture.entity.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {

    private EmployeesDAO employeesDAO;

    @Autowired
    public EmployeesServiceImpl(EmployeesDAO theEmployeesDAO) {
        employeesDAO = theEmployeesDAO;
    }

    @Override
    @Transactional
    public List<Employees> findAll() {
        return employeesDAO.findAll();
    }

    @Override
    @Transactional
    public Employees findById(int theId) {
        return employeesDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employees theEmployees) {
        employeesDAO.save(theEmployees);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeesDAO.deleteById(theId);
    }
}
