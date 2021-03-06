package com.walmart.springboot.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 
 * @author emrah
 * Walmart BookItem Detail Entity  Extends from BookItem
 */
public class BookItemDetail  extends BookItem implements Serializable {
		
	/**
	 * 
	 */
	private static final long serialVersionUID = -2682067628417516921L;
	
	private String longDescription;
	private String largeImage;
	private String isbn;
	private BigDecimal standardShipRate;
	private String stock;
	private String customerRating;
	private String customerRatingImage;
	private boolean freeShippingOver50Dollars;
	private boolean shipToStore;
	
	public String getLongDescription() {
		return longDescription;
	}
	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}
	
	public String getLargeImage() {
		return largeImage;
	}
	public void setLargeImage(String largeImage) {
		this.largeImage = largeImage;
	}

	public String getCustomerRating() {
		return customerRating;
	}
	public void setCustomerRating(String customerRating) {
		this.customerRating = customerRating;
	}
	public String getCustomerRatingImage() {
		return customerRatingImage;
	}
	public void setCustomerRatingImage(String customerRatingImage) {
		this.customerRatingImage = customerRatingImage;
	}
	public String getIsbn() {
		return isbn;
	}
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	public String getStock() {
		return stock;
	}
	public void setStock(String stock) {
		this.stock = stock;
	}
	public boolean isFreeShippingOver50Dollars() {
		return freeShippingOver50Dollars;
	}
	public void setFreeShippingOver50Dollars(boolean freeShippingOver50Dollars) {
		this.freeShippingOver50Dollars = freeShippingOver50Dollars;
	}
	public boolean isShipToStore() {
		return shipToStore;
	}
	public void setShipToStore(boolean shipToStore) {
		this.shipToStore = shipToStore;
	}
	public BigDecimal getStandardShipRate() {
		return standardShipRate;
	}
	public void setStandardShipRate(BigDecimal standardShipRate) {
		if (standardShipRate!= null){
			standardShipRate = standardShipRate.setScale(2, BigDecimal.ROUND_HALF_UP);
		}
		this.standardShipRate = standardShipRate;
	}
}
