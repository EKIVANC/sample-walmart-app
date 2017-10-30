package com.walmart.springboot.utilities;

/**
 * 
 * @author emrah
 * CUSTOM EXCEPTION CLASS TO MANAGE THE APP SPECIFIC EXCEPTIONS
 */
public class WalmartException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -806368822229633393L;

	private String exceptionMessage;
	 
	public WalmartException(String exceptionMessage) {
	      this.exceptionMessage = exceptionMessage;
	   }
	
	 @Override
	 public String toString() { 
	      return ("WalmartException ="+this.exceptionMessage);
	 }
}
