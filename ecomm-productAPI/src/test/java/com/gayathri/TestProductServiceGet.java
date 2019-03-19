package com.gayathri;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.gayathri.exception.HTTP404Exception;
import com.gayathri.spring.dao.ProductDaoRepository;
import com.gayathri.spring.model.Product;
import com.gayathri.spring.service.ProductService;
import com.gayathri.spring.service.ProductServiceImpl;
import com.gayathri.spring.service.feign.CategoryFeignClient;

public class TestProductServiceGet {
	@Spy
	ProductDaoRepository productDao;
	
	@Mock
	CategoryFeignClient cfc;
	
	@InjectMocks
	ProductService prdService = new ProductServiceImpl();
	
	Optional<Product> product;
	Product product1;
	
	@Before
	public void setup()
	{
		MockitoAnnotations.initMocks(this);
		product1 = new Product();
		product1.setId(2L);
		product1.setProductName("TestProduct");
		product1.setLongDescription("Long Description");
		
	}
	
	
	@Test
	public void testProductGetByID() {
		when(productDao.findById(2L)).
		thenReturn(Optional.of(product1));
		assertNotNull(prdService.get(2L));
				
	}
	
	@Test
	public void testProductGetByIDVerify() {
		when(productDao.findById(2L)).
		thenReturn(Optional.of(product1));
		assertNotNull(prdService.get(2L));
		verify(productDao,times(1)).findById(2L);
				
	}
	
	@Test
	public void testProductGetByIDForNullProduct() {
		Product nullProduct = new Product();
		when(productDao.findById(3L)).
		thenReturn(Optional.of(nullProduct));
		assertNotNull(prdService.get(3L));
		assertNull(((prdService.get(3L).get()).getId()));
						
	}
	
	@Test
	public void testProductGetByIDException()
	{
		when(productDao.findById(3L)).
		thenThrow(new HTTP404Exception("No such data found"));
		assertThatExceptionOfType(HTTP404Exception.class)
		.isThrownBy(() -> {prdService.get(3L);}).
		withMessage("No such data found");
	}

}
