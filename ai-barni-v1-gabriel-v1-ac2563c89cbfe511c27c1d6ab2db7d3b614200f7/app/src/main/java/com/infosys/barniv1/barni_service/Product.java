package com.infosys.barniv1.barni_service;

import com.google.gson.annotations.SerializedName;

/**
 * Created by adrian on 2/7/2018.
 */

public class Product {

    @SerializedName("productId")
    private Long productId;

    private String productImagePath;
    private String productName;
    private String productDescription;

    public Product() {
    }

    public Product(Long productId, String productImagePath, String productName, String productDescription) {
        this.productId = productId;
        this.productImagePath = productImagePath;
        this.productName = productName;
        this.productDescription = productDescription;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductImagePath() {
        return productImagePath;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductImagePath(String productImagePath) {
        this.productImagePath = productImagePath;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }
}
