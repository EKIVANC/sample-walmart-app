package com.walmart.springboot.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.walmart.springboot.model.BookItem;

public class PaginatedItemList {

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
