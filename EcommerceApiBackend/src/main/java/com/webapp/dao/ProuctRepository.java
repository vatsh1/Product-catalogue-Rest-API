package com.webapp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webapp.model.Product;
import com.webapp.model.User;

@Repository
public interface ProuctRepository extends CrudRepository<Product, Integer> {
	public Product findById(int id);
	
	
}
