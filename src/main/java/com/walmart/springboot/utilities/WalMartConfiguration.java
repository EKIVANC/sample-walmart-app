package com.walmart.springboot.utilities;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;



/***
 * 
 * @author emrah
 *	READ application.properties file and Set Values! 
 */
@EnableCaching
@Configuration
@Service
@ConfigurationProperties("walmart")
public class WalMartConfiguration {

	// special API key for client application
    private String apiKey;
    
    // For Taxonomy Service URL 
    private String uri4taxonomy;
    
    // For Products Service URL
    private String uri4Items;

    // For Products Details Service URL
    private String uri4ItemDetails;
    
    // For Customer Review Service URL
    private String uri4CustomerReviews;

    // For PageSize which is defined in SPEC document of the assignment
	private Integer pageSize;
    
	//final String uri4taxonomy = "http://api.walmartlabs.com/v1/taxonomy?apiKey=r3ywye5qsf64vfrdhx8sv4f9&format=json";
	//final String uri4Items = "http://api.walmartlabs.com/v1/paginated/items?category=3920&apiKey=r3ywye5qsf64vfrdhx8sv4f9&format=json";
	
	// create a complete URL
	public String getTaxonomyUri(){
		return uri4taxonomy+"?apiKey="+apiKey;
	}

	// create a complete URL
	public String getUri4Items(String category){
		return uri4Items+"?category="+category+"&apiKey="+apiKey;
	}
	
	// create a complete URL
	public String getUri4Items(String category, String maxId){
		return uri4Items+"?category="+category+"&maxId="+maxId+"&apiKey="+apiKey;
	}
	
	// create a complete URL
	public String getUri4ItemDetails(String itemId){
		return uri4ItemDetails+"/"+itemId+"?apiKey="+apiKey;
	}
	
	// create a complete URL
	public String getUri4CustomerReviews(String itemId){
		return uri4CustomerReviews+"/"+itemId+"?apiKey="+apiKey;
	}

	/*
	 *  AUTO GENERATED -  GETTERS & SETTERS
	 * 
	 */
	public String getUri4taxonomy() {
		return uri4taxonomy;
	}

	public void setUri4taxonomy(String uri4taxonomy) {
		this.uri4taxonomy = uri4taxonomy;
	}

	public String getUri4Items() {
		return uri4Items;
	}

	public void setUri4Items(String uri4Items) {
		this.uri4Items = uri4Items;
	}
	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getUri4ItemDetails() {
		return uri4ItemDetails;
	}

	public void setUri4ItemDetails(String uri4ItemDetails) {
		this.uri4ItemDetails = uri4ItemDetails;
	}

	public String getUri4CustomerReviews() {
		return uri4CustomerReviews;
	}

	public void setUri4CustomerReviews(String uri4CustomerReviews) {
		this.uri4CustomerReviews = uri4CustomerReviews;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
}