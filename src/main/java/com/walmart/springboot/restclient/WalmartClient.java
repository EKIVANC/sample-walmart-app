package com.walmart.springboot.restclient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.walmart.springboot.model.BookItem;
import com.walmart.springboot.model.BookItemDetail;
import com.walmart.springboot.model.Categories;
import com.walmart.springboot.model.Category;
import com.walmart.springboot.model.CustomerReviews;
import com.walmart.springboot.model.PaginatedItemList;
import com.walmart.springboot.utilities.WalMartConfiguration;
import com.walmart.springboot.utilities.WalmartException;

/**
 * 
 * @author emrah
 * Responsible for making Restful Calls to Walmart
 * Walmart integration 
 */
@Service
public class WalmartClient {
	
	/*
	 * Configurable parameters are stored in application.properties file
	 * the file is accessed by walMartConfiguration class
	 */
	@Autowired(required=true)
	private WalMartConfiguration walMartConfiguration;
	
	/*
	 *walMartConfiguration has to be provided to populate! 
	 */
	public WalmartClient(WalMartConfiguration walMartConfiguration) {
		this.walMartConfiguration = walMartConfiguration;
	}
	
	/*
	 * Get Category ID Dynamically by the Walmart Service!
	 * Avoid usging HardCodded category IDs!
	 * Taxonomy Service are provided
	 * 
	 * @Cacheable  
	 */
	@Cacheable("BookCategoryId")
	public String getBookCategoryId() throws WalmartException{
		String walmartApiKey = walMartConfiguration.getApiKey();
		 RestTemplate restTemplate = new RestTemplate();
		 Categories categories = restTemplate.getForObject(walMartConfiguration.getTaxonomyUri(), Categories.class);
		 if(categories != null){
			 Optional<Category> bookCategory = categories.getCategoryList().stream().filter( categoryItem ->  categoryItem.getPath().equals("Books") ).findFirst();
			 return bookCategory.get().getId();
		 }
		 throw new WalmartException("Could not get Book Category Id");
	}
	
	/*
	 * Get Book List to be used in Main Page
	 * if maxIds is null, get first page!
	 * @Cacheable
	 */
	@Cacheable("BooksByMaxId")
	public List<BookItem> getBooks(List<String> maxIds) throws RestClientException, WalmartException{
		String bookCategId= getBookCategoryId();
		List<BookItem> retVal = new ArrayList<BookItem>();
		if(maxIds == null || maxIds.size() == 0){
			retVal.addAll(getBookswithURI(walMartConfiguration.getUri4Items(bookCategId)));	
		}
		
		if(maxIds != null && maxIds.size() >0 ){
			retVal.addAll(getBookswithURI(walMartConfiguration.getUri4Items(bookCategId)));
			for (String tmpMaxId : maxIds) {
				retVal.addAll(getBookswithURI(walMartConfiguration.getUri4Items(bookCategId,tmpMaxId)));	
			}
		}
		
		return retVal;
	}
	
	/*
	 * Get Books with the specified restFul Service URi
	 */
	@Cacheable("Books")
	private List<BookItem> getBookswithURI(String uri) throws WalmartException {
		RestTemplate restTemplate = new RestTemplate();
		PaginatedItemList paginatedItemList = restTemplate.getForObject(uri, PaginatedItemList.class);
		return paginatedItemList.getItems();
	}

	/*
	 * Get BookDetail by ItemId
	 * @Cacheable,
	 */
	@Cacheable("BookDetail")
	public BookItemDetail getBookDetail(String itemId) throws  RestClientException, WalmartException{
		if(itemId== null || itemId.length()==0 ){
			throw new WalmartException("itemId is mandatory");
		}
		RestTemplate restTemplate = new RestTemplate();
		BookItemDetail bookItemDetail = restTemplate.getForObject(walMartConfiguration.getUri4ItemDetails(itemId), BookItemDetail.class);
		return bookItemDetail;
	}
	
	/*
	 * Get Customer Reviews of Item
	 * This service is not available anymore -  30.10.17
	 * @Cacheable,
	 */
	@Cacheable("CustomerReviews")
	public CustomerReviews getCustomerReviews(String itemId) throws   RestClientException, WalmartException{
		RestTemplate restTemplate = new RestTemplate();
		CustomerReviews customerReviews = restTemplate.getForObject(walMartConfiguration.getUri4CustomerReviews(itemId), CustomerReviews.class);
		return customerReviews; 
	}
	
//	/*
//	 * This method is responsible for clearing the cache
//	 */
//	 @CacheEvict(allEntries = true)
//	 public void clearCache(){}
	
}
