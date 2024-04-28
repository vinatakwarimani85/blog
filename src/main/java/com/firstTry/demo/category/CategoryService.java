package com.firstTry.demo.category;

import java.util.List;

public interface CategoryService {
    public CategoryDto createCategory(CategoryDto categoryDto);
    public  CategoryDto updateCategory(CategoryDto categoryDto,Integer id);
    public CategoryDto getCategory(Integer id);
    public List<CategoryDto> getAllCategory();
    public  void  deleteCategory();
}
