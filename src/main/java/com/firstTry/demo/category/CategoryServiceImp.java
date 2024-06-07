package com.firstTry.demo.category;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
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
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto,Category.class);
		//Category category = catDto.dtoToCategory(categoryDto);
		Category savedCategory = categoryRepo.save(category);
		//CategoryDto cat = catDto.categoryToDto(savedCategory);
		CategoryDto cat = this.modelMapper.map(savedCategory, CategoryDto.class);
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
	    //return catDto.categoryToDto(updatedCat);
	    return this.modelMapper.map(updatedCat, CategoryDto.class);
	    
	}

	@Override
	public CategoryDto getCategory(int id) {
		Category cat = categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", id));
		//return catDto.categoryToDto(cat);
		return this.modelMapper.map(cat, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategory() {
		List<Category> catList =categoryRepo.findAll();
		List<CategoryDto> catDtoList =new ArrayList();
		for(Category cat:catList) {
			catDtoList.add(this.modelMapper.map(cat, CategoryDto.class));
		}
		return catDtoList;
	}

	@Override
	public void deleteCategory(int id) {
		Category cat = categoryRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId", id));
		categoryRepo.delete(cat);
	}

}
