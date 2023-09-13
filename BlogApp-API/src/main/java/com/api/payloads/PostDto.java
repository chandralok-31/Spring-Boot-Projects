package com.api.payloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class PostDto {

	private Integer postId;
	
	@NotEmpty
	@Size(min = 4,message="title must be min of 4 character !!")
	private String title;
	
	@NotEmpty
	@Size(min = 10,message="content must be min of 10 character !!")
	private String content;
	
	private String imageName;
	
	private Date addedDate;
	
	private CategoryDto category;
	
	private UserDto user;
	
	private Set<CommentDto> comments=new HashSet<>();
}
