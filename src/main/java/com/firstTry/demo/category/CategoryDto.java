package com.firstTry.demo.category;

public class CategoryDto {

    private int categoryId;
    private String categoryTitle;
    private  String categoryDiscription;

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setCategoryTitle(String categoryTitle) {
        this.categoryTitle = categoryTitle;
    }

    public void setCategoryDiscription(String categoryDiscription) {
        this.categoryDiscription = categoryDiscription;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public String getCategoryDiscription() {
        return categoryDiscription;
    }
}
