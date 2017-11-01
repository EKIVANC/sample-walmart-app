package com.walmart.springboot.model;

import java.io.Serializable;

public class Review implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5585412403793959315L;
	private String reviewer;
	private String title;
	private String reviewText;
	
	
	public String getReviewer() {
		return reviewer;
	}
	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getReviewText() {
		return reviewText;
	}
	public void setReviewText(String reviewText) {
		this.reviewText = reviewText;
	}
	
	
	
}
