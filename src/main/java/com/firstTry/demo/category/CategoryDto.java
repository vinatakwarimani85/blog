package com.firstTry.demo.category;

import org.springframework.stereotype.Component;

@Component
public class CategoryDto {

    private int categoryId;
    private String categoryTitle;
    private  String categoryDiscription;

    public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
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

    public int getCategoryId() {
        return categoryId;
    }

    public String getCategoryTitle() {
        return categoryTitle;
    }

    public String getCategoryDiscription() {
        return categoryDiscription;
    }
    
    public Category dtoToCategory(CategoryDto catDto) {
    	Category category = new Category();
    	category.setCategoryId(catDto.getCategoryId());
    	category.setCategoryTitle(catDto.getCategoryTitle());
    	category.setCategoryDiscription(catDto.getCategoryDiscription());
    	return category;
    }
    
    public CategoryDto categoryToDto(Category cat) {
    	CategoryDto categoryDto = new CategoryDto();
    	categoryDto.setCategoryId(cat.getCategoryId());
    	categoryDto.setCategoryDiscription(cat.getCategoryDiscription());
    	categoryDto.setCategoryTitle(cat.getCategoryTitle());
    	
    	return categoryDto;
    	
    }
}
