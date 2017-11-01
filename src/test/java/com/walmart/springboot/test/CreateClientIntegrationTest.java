package com.walmart.springboot.test;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.BDDMockito.given;

import com.walmart.springboot.controller.WalmartController;
import com.walmart.springboot.model.BookItemDetail;
import com.walmart.springboot.restclient.WalmartClient;
import com.walmart.springboot.utilities.WalmartException;

import org.junit.rules.ExpectedException;

/**
 * 
 * @author emrah
 * Unit Test Class, natirally runs before mvn install command 
 */
@RunWith(SpringRunner.class)
@RestClientTest(WalmartController.class)
public class CreateClientIntegrationTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Mock
	private WalmartClient client;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this); 
		this.client = new WalmartClient();
	}
	
	/*
	 * itemId is mandatory when CallingGetBookDetails 
	 */
	@Test(expected = WalmartException.class)
	public void whenCallingGetBookDetails() throws Exception {
		given(this.client.getBookDetail(null)).willReturn( new BookItemDetail() );
	}

}