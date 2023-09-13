package com.api.services;

import java.util.List;



import com.api.payloads.PostDto;
import com.api.payloads.PostResponse;

public interface PostService {

	//create
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
	//update
	PostDto updatePost(PostDto postDto,Integer postId);
	
	//delete
	void deletePost(Integer postId);
	
	//get All posts
	PostResponse getAllPost(Integer pageNumber,Integer pageSize,String sortBy,String sortDir);
	
	//get single post
	PostDto getPostById(Integer postId);
	
	//get All post by category
	List<PostDto> getPostsByCategory(Integer categoryId);
	
	//get All post by user
	List<PostDto> getPostsByUser(Integer userId);
	
	
	//search post 
	List<PostDto> searchPosts(String keyword);
	
}
