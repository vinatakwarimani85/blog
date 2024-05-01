package com.firstTry.demo.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class CategoryControler {
	
	@Autowired
	private CategoryService catService;

	@PostMapping("/create-category")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto catDto){
		CategoryDto createdCat=  catService.createCategory(catDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCat);
	}
	
	@PostMapping("/update-category")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto catDto){
		int id = catDto.getCategoryId();
		CategoryDto updatedCat = catService.updateCategory(catDto,id);
		return ResponseEntity.status(HttpStatus.OK).body(updatedCat);
	}
	
	
}
