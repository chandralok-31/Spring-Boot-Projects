package com.api.services.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.entities.Category;
import com.api.exceptions.ResourceNotFoundException;
import com.api.payloads.CategoryDto;
import com.api.repository.CategoryRepo;
import com.api.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepo categoryRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category=this.dtoTocategory(categoryDto);
		Category savedCategory=this.categoryRepo.save(category);
		return this.categoryToDto(savedCategory);
	}

	
	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCategory=this.categoryRepo.save(category);
		CategoryDto categoryDto1=this.categoryToDto(updatedCategory);
		return categoryDto1;
	}

	@Override
	public void deleteCategory(Integer categoryId) {
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
		this.categoryRepo.delete(category);
		
	}

	@Override
	public CategoryDto getCategory(Integer categoryId) {
		Category category=this.categoryRepo.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "Id", categoryId));
		
		return this.categoryToDto(category);
	}

	@Override
	public List<CategoryDto> getCategories() {
		List<Category> categories=this.categoryRepo.findAll();
		List<CategoryDto> categoryDto=categories.stream().map(category ->this.categoryToDto(category)).collect(Collectors.toList());
		return categoryDto;
	}

	public Category dtoTocategory(CategoryDto categoryDto) {
		Category category=this.modelMapper.map(categoryDto, Category.class);
		return category;
	}

	public CategoryDto categoryToDto(Category category) {
		CategoryDto categoryDto=this.modelMapper.map(category, CategoryDto.class);
		return categoryDto;
	}

}
