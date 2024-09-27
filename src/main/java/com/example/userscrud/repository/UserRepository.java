package com.example.userscrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.userscrud.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query(value = "SELECT * FROM user WHERE email = ?1", nativeQuery = true)
	User findByEmailAddress(String emailAddress);


	@Query(value = "SELECT * FROM user WHERE name = ?1", nativeQuery = true)
	User findByName(String name);


	@Modifying
	@Query(value = "DELETE FROM user WHERE email = ?1", nativeQuery = true)
	void deleteByEmail(String email);


	@Query(value = "SELECT COUNT(*) FROM user WHERE name = ?1", nativeQuery = true)
	Integer getUserNameCount(String name);

	
	@Modifying
	@Query(value = "DELETE FROM user WHERE name = ?1", nativeQuery = true)
	void deleteByName(String name);
}
