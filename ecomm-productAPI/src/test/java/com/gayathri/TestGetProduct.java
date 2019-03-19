package com.gayathri;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.gayathri.spring.controller.ProductController;
import com.gayathri.spring.model.Product;
import com.gayathri.spring.service.ProductService;
import com.gayathri.spring.service.ProductServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class TestGetProduct {

	Product product1;
	@Autowired
    private WebApplicationContext wac;
	  
	  @Autowired
	    private MockMvc mockMvc;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		product1 = new Product();
		product1.setId(2L);
		product1.setProductName("TestProduct");
		product1.setLongDescription("Long Description");
		this.mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
		
	}
	
	@Mock
	private ProductService productService = new ProductServiceImpl();
	
	
	@Mock
	private ProductController productController;
	
	
	
	
//	 @Test
//	    public void testGetObjectAList() {
//	        ObjectA myobjectA = new ObjectA();
//	        //define the entity you want the exchange to return
//	        ResponseEntity<List<ObjectA>> myEntity = new ResponseEntity<List<ObjectA>>(HttpStatus.ACCEPTED);
//	        Mockito.when(restTemplate.exchange(
//	            Matchers.eq("/objects/get-objectA"),
//	            Matchers.eq(HttpMethod.POST),
//	            Matchers.<HttpEntity<ObjectA>>any(),
//	            Matchers.<ParameterizedTypeReference<List<ObjectA>>>any())
//	        ).thenReturn(myEntity);
//
//	        List<ObjectA> res = underTest.getListofObjectsA();
//	        Assert.assertEquals(myobjectA, res.get(0));
//	    }
	 
	@Test
	public void testNoResult() throws Exception
	{
		/*ResponseEntity<Product> resp = new ResponseEntity<Product>(HttpStatus.ACCEPTED);
		when(restTemplate.exchange(
				Matchers.equalTo("/product/1"),
				Matchers.equalTo(HttpMethod.GET),
				Matchers.<HttpEntity<Product>>any(null),
				Matchers.<ParameterizedTypeReference<Product>> any())).
 				thenReturn(resp);*/
		
		 this.mockMvc.perform(get("/category/4")).andDo(print()).andExpect(status().isOk());
		 /*andExpect(status().isOk())
         .andExpect(content().string(containsString("Hello World")));*/
	}

	

    
}
