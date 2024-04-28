package com.firstTry.demo.category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Category {
    @Id
    @GeneratedValue
    private  int categoryId;

    @Column(name ="title")
    private  String categoryTitle;

    @Column(name = "description")
    private   String categoryDiscription;

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public String getCategoryDiscription() {
        return categoryDiscription;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public void setCategoryDiscription(String categoryDiscription) {
        this.categoryDiscription = categoryDiscription;
    }
}
