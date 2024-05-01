package com.firstTry.demo.category;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.firstTry.demo.exceptions.ResourceNotFoundException;
import com.firstTry.demo.user.User;

@Component
public class CategoryServiceImp implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;
	
	@Autowired
	private CategoryDto catDto;
	
	private ModelMap model;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = catDto.dtoToCategory(categoryDto);
		Category savedCategory = categoryRepo.save(category);
		CategoryDto cat = catDto.categoryToDto(savedCategory);
		return cat;
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer id) {
		Category cat = categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", id));
		cat.setCategoryId(id);
	    if(categoryDto.getCategoryTitle()!=null)
	    	cat.setCategoryTitle(categoryDto.getCategoryTitle());
	    if(categoryDto.getCategoryDiscription()!=null)
	    	cat.setCategoryDiscription(categoryDto.getCategoryDiscription());
	    Category updatedCat = categoryRepo.save(cat);
	    return catDto.categoryToDto(updatedCat);
	}

	@Override
	public CategoryDto getCategory(Integer id) {
		Category cat = categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", id));
		return catDto.categoryToDto(cat);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> catList =categoryRepo.findAll();
		List<CategoryDto> catDtoList =new ArrayList();
		for(Category cat:catList) {
			catDtoList.add(catDto.categoryToDto(cat));
		}
		return catDtoList;
	}

	@Override
	public void deleteCategory(Integer id) {
		Category cat = categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", id));
		categoryRepo.delete(cat);
	}

}
