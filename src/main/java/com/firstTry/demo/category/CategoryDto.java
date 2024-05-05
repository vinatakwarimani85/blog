package com.firstTry.demo.category;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.firstTry.demo.posts.Post;

@Component
public class CategoryDto {

    private int categoryId;
    private String categoryTitle;
    private  String categoryDiscription;
    


    public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Autowired
	private ModelMapper modelMapper;


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
    	return this.modelMapper.map(catDto, Category.class);
    }
    
    public CategoryDto categoryToDto(Category cat) {
    	CategoryDto categoryDto = new CategoryDto();
    	return this.modelMapper.map(cat, CategoryDto.class);
    	
    }
}
