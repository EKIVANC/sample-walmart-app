package com.walmart.springboot.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author emrah
 * Walmart BookItem Entity
 */
public class BookItem implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3349435368525354774L;
	
	private String thumbnailImage;
	private String mediumImage;
	private String name;
	private BigDecimal msrp;
	private BigDecimal salePrice;
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
	public BigDecimal getMsrp() {
		return msrp;
	}
	public void setMsrp(BigDecimal msrp) {
		if (msrp!= null){
			msrp = msrp.setScale(2, BigDecimal.ROUND_HALF_UP);	
		}
		this.msrp = msrp;
	}
	public BigDecimal getSalePrice() {
		return salePrice;
	}
	public void setSalePrice(BigDecimal salePrice) {
		if (salePrice!= null){
			salePrice = salePrice.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		this.salePrice = salePrice;
	}
	
	
}
