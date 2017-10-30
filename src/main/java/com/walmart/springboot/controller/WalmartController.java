package com.walmart.springboot.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringEscapeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.walmart.springboot.model.BookItem;
import com.walmart.springboot.model.BookItemDetail;
import com.walmart.springboot.model.CustomerReviews;
import com.walmart.springboot.restclient.WalmartClient;
import com.walmart.springboot.utilities.WalMartConfiguration;

@Controller
public class WalmartController {
	
	/*
	 * Configuration is responsible to store configurable variables like service URLs 
	 * it uses application.properties file  
	 */
	@Autowired
	private WalMartConfiguration walMartConfiguration;

	/*
	 * Serve the page with pagination functionalities
	 */
	@RequestMapping("/")
	public ModelAndView index(@RequestParam(required = false) Integer page, HttpServletRequest request) {
		
		ModelAndView model = new ModelAndView("index");
		/*
		 * Client is for making rest requests
		 */
		WalmartClient mc = new WalmartClient(this.walMartConfiguration);
		List<BookItem> list = new ArrayList<BookItem>();
		
		/*
		 * Set Error Message variable in case of any Errors or Exceptions
		 */
		String errorMessage = null;
		
		try {
			if(request.getSession().getAttribute("maxPages") != null &&
					page != null && 
					page!= 0 && 
					(page + 1 >  (Integer) request.getSession().getAttribute("maxPages") ) 
			   ){
				
					/*
					 * Store maxIds reached in the http session, 
					 * thus The Paginated Products Service can be called again when needed 
					 */
					List<String> maxIds = (List<String>) request.getSession().getAttribute("maxIds");
					list = mc.getBooks(maxIds);
					maxIds.add( list.get(list.size()-1).getItemId() );
					request.getSession().setAttribute("maxIds", maxIds);
				
			}
			
			else{
				list = mc.getBooks(null);
				List<String> maxIds = new ArrayList<>();
				maxIds.add( list.get(list.size()-1).getItemId() );
				request.getSession().setAttribute("maxIds", maxIds);
			}
			
			errorMessage = null;
		} catch (Exception e) {
			errorMessage = "an error occured: " + e.getMessage();
			list = null;
			
			/*
			 * A logger framework could be integrated and logs could be archived instead of printStackTrace 
			 */
			e.printStackTrace();
			
			/*
			 * if errorMessage field is Setted, it will be displayed on page!   
			 */
			model.addObject("errorMessage", errorMessage);
			return model;
		}
		
		/*
		 * Spring Framework provides PagedListHolder class for pagination functionality on lists 
		 */
		PagedListHolder<BookItem> pagedListHolder = new PagedListHolder<>(list);
		
		/*
		 * Set Page Size - this was determined in assignmet spec
		 */
		pagedListHolder.setPageSize(20);
		model.addObject("maxPages", pagedListHolder.getPageCount());
		request.getSession().setAttribute("maxPages",pagedListHolder.getPageCount());
		
		if(page == null || page < 1 || page > pagedListHolder.getPageCount()){
			    page = 1;
			    /*
			     * Be careful initial page is Zero - not One
			     */
	            pagedListHolder.setPage(0);
	     }
		else{ 
			/*
			 * Set Page index to page -1 as it already starts with Zero!
			 */
            pagedListHolder.setPage(page-1);
        }
		model.addObject("lists", pagedListHolder.getPageList());
		model.addObject("page", page);

		return model;
	}

	/*
	 * This method is responsible for Product Details
	 */
	@RequestMapping(value = "/productDetail/{itemId}", method = RequestMethod.GET)
	public ModelAndView viewProductDetails(@PathVariable String itemId) {
		ModelAndView model = new ModelAndView("productDetail");
		/*
		 * This client is responsible for making rest calls to walmart!
		 */
		WalmartClient mc = new WalmartClient(this.walMartConfiguration);
		String errorMessage = null;
		BookItemDetail bookDetail = null;
		try {
			bookDetail = mc.getBookDetail(itemId);
			errorMessage = null;
			bookDetail.setLongDescription(StringEscapeUtils.unescapeXml(bookDetail.getLongDescription()));
			model.addObject("bookDetail", bookDetail);
		} catch (Exception e) {
			errorMessage = "an error occured in BookDetail Service: " + e.getMessage();
			e.printStackTrace();
			bookDetail = null;
			model.addObject("errorMessage", errorMessage);
		}
		
		/*
		 * CustomerReview service is not working!  
		 * Comment Date: 30.10.17 
		 */
		CustomerReviews customerReview = null;
		try {
			customerReview = mc.getCustomerReviews(itemId);
			errorMessage = null;
			model.addObject("customerReview", customerReview);
		} catch (Exception e) {
			errorMessage = "an error occured in CustomerReviews Service: " + e.getMessage();
			e.printStackTrace();
			customerReview = null;
			model.addObject("errorMessage", errorMessage);
		}
		 
		return model;
	}

}