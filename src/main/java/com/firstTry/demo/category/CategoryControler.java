package com.firstTry.demo.category;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.firstTry.demo.ResponseHandler.copy.ApiResponse;
import com.firstTry.demo.user.UserDto;

@RestController
public class CategoryControler {
	
	@Autowired
	private CategoryService catService;

	@PostMapping("/create-category")
	public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto catDto){
		CategoryDto createdCat=  catService.createCategory(catDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(createdCat);
	}
	
	@PutMapping("/update-category")
	public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto catDto){
		int id = catDto.getCategoryId();
		CategoryDto updatedCat = catService.updateCategory(catDto,id);
		return ResponseEntity.status(HttpStatus.OK).body(updatedCat);
	}
	
	@GetMapping("/get-category")
	public ResponseEntity<CategoryDto> getCategory(@RequestBody CategoryDto catDto){
		int id = catDto.getCategoryId();
		CategoryDto foundCat =  catService.getCategory(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(foundCat);
	}
	
	@GetMapping("/get-all-category")
	public ResponseEntity<List<CategoryDto>> getAllCategory(){
		List<CategoryDto> catList=catService.getAllCategory();
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(catList);
		
	}
	
	@DeleteMapping("/delete-category")
	public ResponseEntity<?> deleteCategory(@RequestBody CategoryDto catDto){
		int id = catDto.getCategoryId();
		catService.deleteCategory(id);
		return new ResponseEntity(Map.of("message","category deleted sucessfully"),HttpStatus.OK);
	}
}
