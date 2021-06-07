package com.njegovanovic.internetsoftverskearhitekture.service;

import com.njegovanovic.internetsoftverskearhitekture.entity.Products;

import java.util.List;

public interface ProductsService {

    List<Products> findAll();

    Products findById(String theId);

    void save(Products theProducts);

    void deleteById(String theId);
}
