package com.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.entities.Category;

public interface CategoryRepo extends JpaRepository<Category, Integer> {

}
