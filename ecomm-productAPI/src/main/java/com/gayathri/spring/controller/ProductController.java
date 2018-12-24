package com.gayathri.spring.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gayathri.event.ProductEvent;
import com.gayathri.spring.model.Product;
import com.gayathri.spring.service.ProductService;


@RestController
public class ProductController extends AbstractController{

   @Autowired
   private ProductService  productService;

   /*---Add new Product---*/
   @PostMapping("/product")
   public ResponseEntity<?> save(@RequestBody Product product) {
      Product productResult = productService.save(product);
      PublishEvent(product,"ProductCreated");
      return ResponseEntity.ok().body("New Product has been saved with ID:" + productResult.getId());
   }



   /*---Get a Product by id---*/
   @GetMapping("/product/{id}")
   public ResponseEntity<Product> get(@PathVariable("id") long id) {
	   Optional<Product> productResult = productService.get(id);
	   PublishEvent(productResult.get(),"ProductRetrieved");
      return ResponseEntity.ok().body(productResult.get());
   }

   /*---get all Products paginated---*/
   @GetMapping("/product")
   public @ResponseBody Page<Product> list(@RequestParam (value="pagenumber",required=true,defaultValue="0") Integer PageNumber,
		   @RequestParam (value="pagesize",required=true,defaultValue="10") Integer PageSize) {
     Page<Product> products = productService.getProductByPage(PageNumber, PageSize);
      return products;
   }

   /*---Update a Product by id---*/
   @PutMapping("/product/{id}")
   public ResponseEntity<?> update(@PathVariable("id") long id, @RequestBody Product product) {
      productService.update(id, product);
      PublishEvent(product,"ProductUpdated");
      return ResponseEntity.ok().body("Product has been updated successfully.");
   }

   /*---Delete a Product by id---*/
   @DeleteMapping("/product/{id}")
   public ResponseEntity<?> delete(@PathVariable("id") long id) {
      productService.delete(id);
      PublishEvent(null,"ProductDeleted");
      return ResponseEntity.ok().body("Product has been deleted successfully.");
   }
   
   private void PublishEvent(Product product,String EventType) {
		ProductEvent productmodified = new ProductEvent(ProductController.class);
	      productmodified.setEventType(EventType);
	      productmodified.setProduct(product);
	      getEventPublisher().publishEvent(productmodified);
	}
}