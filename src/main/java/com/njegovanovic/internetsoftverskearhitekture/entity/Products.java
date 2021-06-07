package com.njegovanovic.internetsoftverskearhitekture.entity;

import javax.persistence.*;

@Entity
@Table(name="products")
public class Products {

    @Id
    @Column(name = "productCode")
    private String productCode;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productLine")
    private String productLine;

    @Column(name = "productVendor")
    private String productVendor;

    @Column(name = "productDescription")
    private String productDescription;

    @Column(name = "buyPrice")
    private double buyPrice;

    public Products() {}

    public Products(String productCode, String productName, String productLine, String productVendor, String productDescription, double buyPrice) {
        this.productCode = productCode;
        this.productName = productName;
        this.productLine = productLine;
        this.productVendor = productVendor;
        this.productDescription = productDescription;
        this.buyPrice = buyPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductLine() {
        return productLine;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public String getProductVendor() {
        return productVendor;
    }

    public void setProductVendor(String productVendor) {
        this.productVendor = productVendor;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Override
    public String toString() {
        return "Products{" +
                "productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productLine='" + productLine + '\'' +
                ", productVendor='" + productVendor + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", buyPrice=" + buyPrice +
                '}';
    }
}
