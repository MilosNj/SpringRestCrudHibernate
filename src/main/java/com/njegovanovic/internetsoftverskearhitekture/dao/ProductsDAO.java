package com.njegovanovic.internetsoftverskearhitekture.dao;

import com.njegovanovic.internetsoftverskearhitekture.entity.Products;

import java.util.List;

public interface ProductsDAO {

    List<Products> findAll();

    Products findById(String theId);

    void save(Products theProducts);

    void deleteById(String theId);
}
