package com.api.payloads;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {

	private Integer categoryId;
	@NotBlank
	@Size(min = 2,message = "length of categoryTitle must be more than 2 char")
	private String categoryTitle;
	
	@NotBlank
	@Size(min = 6,message = "length of categoryDescription must be more than 6 char")
	private String categoryDescription;
	
}
