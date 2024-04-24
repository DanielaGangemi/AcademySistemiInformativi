package it.corso.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import it.corso.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

	boolean existsByEmail(String email);
	
	User findByEmail(String email);
	
	User findByEmailAndPassword(String email, String password);

}
