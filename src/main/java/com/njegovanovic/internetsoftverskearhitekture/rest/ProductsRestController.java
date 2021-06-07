package com.njegovanovic.internetsoftverskearhitekture.rest;

import com.njegovanovic.internetsoftverskearhitekture.entity.Products;
import com.njegovanovic.internetsoftverskearhitekture.service.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class ProductsRestController {

    private ProductsService productsService;

    @Autowired
    public ProductsRestController(ProductsService theProductsService) {
        productsService = theProductsService;
    }

    @GetMapping("/products")
    public List<Products> findAll() {
        return productsService.findAll();
    }

    @GetMapping("/products/{productCode}")
    public Products getProduct(@PathVariable String productCode) {
        Products theProducts = productsService.findById(productCode);

        if (theProducts == null) {
            throw new RuntimeException("Product ID not found - " + productCode);
        }

        return theProducts;
    }

    @PostMapping("/products")
    public Products addProduct(@RequestBody Products theProducts) {
        productsService.save(theProducts);
        return theProducts;
    }

    @PutMapping("/products")
    public Products updateProduct(@RequestBody Products theProducts) {
        productsService.save(theProducts);
        return theProducts;
    }

    @DeleteMapping("/products/{productCode}")
    public void deleteProduct(@PathVariable String productCode) {
        Products tempProducts = productsService.findById(productCode);

        if (tempProducts == null) {
            throw new RuntimeException("Product ID is not found - " + productCode);
        }

        productsService.deleteById(productCode);

        findAll();
    }
}
