package com.walmart.springboot.model;

import java.io.Serializable;

public class BookItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3349435368525354774L;
	
	private String thumbnailImage;
	private String mediumImage;
	private String name;
	private String msrp;
	private String salePrice;
	private String itemId;
	
	public String getThumbnailImage() {
		return thumbnailImage;
	}
	public void setThumbnailImage(String thumbnailImage) {
		this.thumbnailImage = thumbnailImage;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMsrp() {
		return msrp;
	}
	public void setMsrp(String msrp) {
		this.msrp = msrp;
	}
	public String getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(String salePrice) {
		this.salePrice = salePrice;
	}
	public String getItemId() {
		return itemId;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public String getMediumImage() {
		return mediumImage;
	}
	public void setMediumImage(String mediumImage) {
		this.mediumImage = mediumImage;
	}
}
