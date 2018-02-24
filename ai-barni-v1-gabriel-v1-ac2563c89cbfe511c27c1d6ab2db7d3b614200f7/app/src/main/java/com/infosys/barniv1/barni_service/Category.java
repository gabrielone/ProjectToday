package com.infosys.barniv1.barni_service;

import com.google.gson.annotations.SerializedName;

/**
 * Created by adrian on 2/7/2018.
 */

public class Category {

    @SerializedName("categoryId")
    private Long categoryId;
    private String categoryImagePath;
    private String categoryName;
    private String categoryDescription;


    public Category() {
    }

    public Category(Long categoryId, String categoryImagePath, String categoryName, String categoryDescription) {
        this.categoryId = categoryId;
        this.categoryImagePath = categoryImagePath;
        this.categoryName = categoryName;
        this.categoryDescription = categoryDescription;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryImagePath() {
        return categoryImagePath;
    }

    public void setCategoryImagePath(String categoryImagePath) {
        this.categoryImagePath = categoryImagePath;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

}
