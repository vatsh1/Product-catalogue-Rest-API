package com.webapp.controller;

import java.util.List;
import java.util.Optional;

import com.webapp.model.Product;
import com.webapp.services.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class ProductController {

	@Autowired
	private ProductService productService;

	// get all product handler
	@GetMapping("/products")
	public ResponseEntity<List<Product>> getProducts() {
		List<Product> list = this.productService.getAllProducts();
		return ResponseEntity.of(Optional.of(list));
	}

	// get product by id handler
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable("id") int id) {
		Product product = null;
		try {
			product = this.productService.getProductById(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (product == null)
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		else
			return ResponseEntity.of(Optional.of(product));
	}

	// register product handler
		@PostMapping("/products")
		public ResponseEntity<Product> addProduct(@RequestBody Product product) {
			Product ee = null;
			try {
				ee = this.productService.addProduct(product);
				return ResponseEntity.of(Optional.of(ee));
			} catch (Exception e) {
				e.printStackTrace();
				return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
			}
		}

	// product update handler
	@PostMapping(value = "/products/update")
	public void updateProduct(@RequestBody Product product) {
		try {
			this.productService.updateProduct(product, product.getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// book delete handler
	@GetMapping(value = "/deleteproduct/{id}")
	public ResponseEntity<Product> deletebook(@PathVariable("id") int id) {
		Product product = this.productService.getProductById(id);
		try {
			this.productService.deleteProduct(id);
			return ResponseEntity.ok().body(product);
		} catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}

}
