package com.njegovanovic.internetsoftverskearhitekture.dao;

import com.njegovanovic.internetsoftverskearhitekture.entity.Products;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class ProductsDAOHibernateImpl implements ProductsDAO {

    private EntityManager entityManager;

    @Autowired
    public ProductsDAOHibernateImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Products> findAll() {
        Session currentSession = entityManager.unwrap(Session.class);

        Query<Products> theQuery = currentSession.createQuery("from Products", Products.class);

        List<Products> products = theQuery.getResultList();

        return products;
    }

    @Override
    public Products findById(String theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Products theProducts = currentSession.get(Products.class, theId);

        return theProducts;
    }

    @Override
    public void save(Products theProducts) {
        Session currentSession = entityManager.unwrap(Session.class);

        currentSession.saveOrUpdate(theProducts);
    }

    @Override
    public void deleteById(String theId) {
        Session currentSession = entityManager.unwrap(Session.class);

        Query theQuery = currentSession.createQuery("delete from Products where id=:productCode");
        theQuery.setParameter("productCode", theId);

        theQuery.executeUpdate();
    }
}
