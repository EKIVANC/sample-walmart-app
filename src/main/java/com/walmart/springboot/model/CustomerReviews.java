package com.walmart.springboot.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerReviews {
	
	private String itemId;
	private String name;
	private List<Review> reviews = new ArrayList<>();
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
}
