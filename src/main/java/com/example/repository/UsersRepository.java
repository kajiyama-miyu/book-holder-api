package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.domain.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
	
	List<Users> findByEmail(String email);
	
	List<Users> findByEmailAndPassword(String email, String password);
	
	@Modifying
	@Query(value = "update users set auth = :auth where email = :email", nativeQuery = true)
	public void updateAuth(@Param("auth") String auth, @Param("email") String email);

}
