package com.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.payloads.ApiResponse;
import com.api.payloads.CategoryDto;
import com.api.services.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;

	//create
	@PostMapping("/")
	public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto categoryDto){
		CategoryDto createCategoryDto=this.categoryService.createCategory(categoryDto);
		return new ResponseEntity<CategoryDto>(createCategoryDto,HttpStatus.CREATED);
	}
	
	
	//update
	@PutMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> updateCategory(@Valid @RequestBody CategoryDto categoryDto,@PathVariable("categoryId") Integer cid){
		CategoryDto updatedCategoryDto=this.categoryService.updateCategory(categoryDto, cid);
		return new ResponseEntity<CategoryDto>(updatedCategoryDto,HttpStatus.OK);
	}
	
	//delete
	@DeleteMapping("/{categoryId}")
	public ResponseEntity<ApiResponse> deleteCategory(@PathVariable("categoryId") Integer cid){
		this.categoryService.deleteCategory(cid);
		return new ResponseEntity<ApiResponse>(new ApiResponse("Category deleted successfully",true),HttpStatus.OK);
	}
	
	//get
	@GetMapping("/{categoryId}")
	public ResponseEntity<CategoryDto> getCategory(@PathVariable("categoryId") Integer cid){
		CategoryDto categoryDto=this.categoryService.getCategory(cid);
		return new ResponseEntity<CategoryDto>(categoryDto,HttpStatus.OK);
		}
	
	//get All
	@GetMapping("/")
	public ResponseEntity<List<CategoryDto>> getCategories(){
		List<CategoryDto> categoriesDto=this.categoryService.getCategories();
		return ResponseEntity.ok(categoriesDto);
		}
	
	
}
