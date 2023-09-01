package com.webapp.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.webapp.dao.ProuctRepository;
import com.webapp.model.Product;

@Component
public class ProductService {

	@Autowired
	private ProuctRepository ProductRepository;

	// get all products
	public List<Product> getAllProducts() {
		List<Product> list = (List<Product>) this.ProductRepository.findAll();
		return list;
	}

	// get product by id
	public Product getProductById(int id) {
		Product product = null;
		product = this.ProductRepository.findById(id);
		return product;
	}

	// Add product
	public Product addProduct(Product product) {
		Product result = this.ProductRepository.save(product);
		return result;
	}

	// delete product
	public void deleteProduct(int id) {
		this.ProductRepository.deleteById(id);
	}

	// update product details
	public void updateProduct(Product product, int id) {
		Product updatedProduct = new Product(id, product.getProductCode(), product.getName(), product.getBrand(), product.getPrice(), product.getImage());
		ProductRepository.save(updatedProduct);
	}
}
