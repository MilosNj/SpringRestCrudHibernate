package com.njegovanovic.internetsoftverskearhitekture.service;

import com.njegovanovic.internetsoftverskearhitekture.dao.ProductsDAO;
import com.njegovanovic.internetsoftverskearhitekture.entity.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProductsServiceImpl implements ProductsService {

    private ProductsDAO productsDAO;

    @Autowired
    public ProductsServiceImpl(ProductsDAO theProductsDAO) {
        productsDAO = theProductsDAO;
    }

    @Override
    @Transactional
    public List<Products> findAll() {
        return productsDAO.findAll();
    }

    @Override
    @Transactional
    public Products findById(String theId) {
        return productsDAO.findById(theId);
    }

    @Override
    @Transactional
    public void save(Products theProducts) {
        productsDAO.save(theProducts);
    }

    @Override
    @Transactional
    public void deleteById(String theId) {
        productsDAO.deleteById(theId);
    }
}
