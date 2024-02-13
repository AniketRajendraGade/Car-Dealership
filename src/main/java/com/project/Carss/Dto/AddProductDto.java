package com.project.Carss.Dto;



import lombok.Data;

@Data
public class AddProductDto {
	private String pName;
	private Long price;
	private String description;
	private String imageUrl;

}
