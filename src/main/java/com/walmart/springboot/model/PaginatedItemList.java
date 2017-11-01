package com.walmart.springboot.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.walmart.springboot.model.BookItem;

/**
 * 
 * @author emrah
 * Walmart PaginatedItemList Entity
 */
public class PaginatedItemList implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8339424312367728934L;
	
		private String category;
		private String nextPage;
		
		@JsonProperty("items")
		private List<BookItem> items = new ArrayList<>();
		
		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public String getNextPage() {
			return nextPage;
		}
		public void setNextPage(String nextPage) {
			this.nextPage = nextPage;
		}
		public List<BookItem> getItems() {
			return items;
		}
		public void setItems(List<BookItem> items) {
			this.items = items;
		}
}
