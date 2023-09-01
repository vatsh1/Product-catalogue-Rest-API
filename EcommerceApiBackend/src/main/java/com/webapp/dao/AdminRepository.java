package com.webapp.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.webapp.model.User;

@Repository
public interface AdminRepository extends CrudRepository<User, Integer> {
	public User findById(int id);

	@Query("select a from User a where a.email =:n")
	public User getUserByEmail(@Param("n") String email);
	
	@Query("select a from User a where a.email =:n and a.password = :m")
	public User getUserByEmailNdPass(@Param("n") String email,@Param("m") String password);
}
