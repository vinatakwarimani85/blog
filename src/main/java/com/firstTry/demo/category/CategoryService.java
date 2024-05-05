package com.firstTry.demo.category;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CategoryService {
    public CategoryDto createCategory(CategoryDto categoryDto);
    public  CategoryDto updateCategory(CategoryDto categoryDto,Integer id);
    public CategoryDto getCategory(int id);
    public List<CategoryDto> getAllCategory();
    public  void  deleteCategory(int id);
}
