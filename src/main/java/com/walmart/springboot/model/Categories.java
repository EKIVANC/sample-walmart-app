package com.walmart.springboot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.walmart.springboot.model.Categories;

public class Categories implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5369100384884632992L;
	@JsonProperty(value = "categories")
	private List<Category> categoryList = new ArrayList<Category>();

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
}
