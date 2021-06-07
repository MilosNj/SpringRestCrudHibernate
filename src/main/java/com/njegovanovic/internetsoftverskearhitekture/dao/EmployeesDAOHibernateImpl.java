package com.njegovanovic.internetsoftverskearhitekture.dao;

import com.njegovanovic.internetsoftverskearhitekture.entity.Employees;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeesDAOHibernateImpl implements EmployeesDAO {

    // define field for EntityManager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public EmployeesDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employees> findAll() {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        Query<Employees> theQuery = currentSession.createQuery("from Employees", Employees.class);

        // execute query and get result list
        List<Employees> employees = theQuery.getResultList();

        // return the results
        return employees;
    }

    @Override
    public Employees findById(int theId) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // get the employee
        Employees theEmployees = currentSession.get(Employees.class, theId);

        // return the employee
        return theEmployees;
    }

    @Override
    public void save(Employees theEmployees) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save employee
        currentSession.saveOrUpdate(theEmployees);
    }

    @Override
    public void deleteById(int theId) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        Query theQuery = currentSession.createQuery("delete from Employees where id=:employeeNumber");
        theQuery.setParameter("employeeNumber", theId);

        theQuery.executeUpdate();
    }
}
