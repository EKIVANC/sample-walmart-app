package com.walmart.springboot.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.walmart.springboot.model.Categories;

public class Categories{
	
	@JsonProperty(value = "categories")
	private List<Category> categoryList = new ArrayList<Category>();

	public List<Category> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<Category> categoryList) {
		this.categoryList = categoryList;
	}
	
}
